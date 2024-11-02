package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends Person {
    private String userName; // Renamed from name to userName for clarity
    private String password; // Storing hashed password
    private String role;
    private String villageId; // New field for village ID
  // Assuming you still want to keep this


    public User(String userName, String password, String role, String villageId ) {
        super(villageId); // Assuming villageId is passed to the Person class
        this.userName = userName;
        setPassword(password); // Hash password upon creation
        this.role = role;
        this.role = villageId;
    // Initialize borrowedBooks to 0
    }

    public String getUserName() {
        return userName;
    }

    public String getRole() {
        return role;
    }




    private void setPassword(String password) {
        this.password = hashPassword(password); // Hashing the password
    }

    public boolean checkPassword(String password) {
        return this.password.equals(hashPassword(password)); // Check against hashed password
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
