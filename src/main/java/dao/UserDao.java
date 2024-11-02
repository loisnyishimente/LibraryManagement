package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserDao {
    private Connection connection;

    public UserDao(Connection connection) {
        this.connection = connection;
    }

    // Method to save user details, including hashed password
    public void saveUser(String userName, String password, String role, String villageId) throws Exception {
        // Hash the password before storing it
        String hashedPassword = hashPassword(password);

        String query = "INSERT INTO user (user_name, password, role, village_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userName);
            statement.setString(2, hashedPassword); // Store the hashed password
            statement.setString(3, role);
            statement.setString(4, villageId);

            statement.executeUpdate();
        }
    }

    // Check if the username already exists in the database
    public boolean existsByName(String userName) throws Exception {
        String query = "SELECT COUNT(*) FROM user WHERE user_name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0; // Returns true if the count is greater than 0
            }
            return false; // Returns false if there are no matching records
        }
    }

    // Hashing method for passwords
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}
