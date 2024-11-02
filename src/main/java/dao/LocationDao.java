package dao;

import model.Location;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LocationDao {
    private Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }

    // Method to save a new parent location and return its ID
    public int saveParentLocation(Location location) throws SQLException {
        String query = "INSERT INTO location (location_code, location_name, location_type) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, location.getLocationCode());
            statement.setString(2, location.getLocationName());
            statement.setString(3, location.getLocationType());
            int affectedRows = statement.executeUpdate();

            // Check if the insert was successful
            if (affectedRows == 0) {
                throw new SQLException("Inserting location failed, no rows affected.");
            }

            // Retrieve the generated keys (i.e., the location_id)
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the auto-generated location_id
                } else {
                    throw new SQLException("Creating location failed, no ID obtained.");
                }
            }
        }
    }

    // Method to save a new child location
    public void saveChildLocation(Location location) throws Exception {
        // Check if the parent location exists
        if (location.getParentId() != null) {
            String checkParentQuery = "SELECT COUNT(*) FROM location WHERE location_id = ?";
            try (PreparedStatement checkStatement = connection.prepareStatement(checkParentQuery)) {
                checkStatement.setInt(1, location.getParentId());
                ResultSet resultSet = checkStatement.executeQuery();
                if (resultSet.next() && resultSet.getInt(1) == 0) {
                    throw new Exception("Parent location with ID " + location.getParentId() + " does not exist.");
                }
            }
        }

        // Insert the new child location
        String query = "INSERT INTO location (location_code, location_name, location_type, parent_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, location.getLocationCode());
            statement.setString(2, location.getLocationName());
            statement.setString(3, location.getLocationType());
            statement.setObject(4, location.getParentId(), java.sql.Types.INTEGER); // Handle null parent_id
            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Inserting child location failed, no rows affected.");
            }
        }
    }

    // Method to get all locations of a specific type
    public List<Location> getLocationsByType(String locationType) throws Exception {
        List<Location> locations = new ArrayList<>();
        String query = "SELECT * FROM location WHERE location_type = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, locationType);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Location location = new Location(
                        resultSet.getString("location_code"),
                        resultSet.getString("location_name"),
                        resultSet.getString("location_type"),
                        resultSet.getInt("parent_id")
                );
                locations.add(location);
            }
        }
        return locations;
    }

    public void saveLocation(Location location) throws Exception {
        // Example usage: Choose to save as parent or child based on your logic
        if (location.getParentId() == null) {
            saveParentLocation(location);
        } else {
            saveChildLocation(location);
        }
    }
}
