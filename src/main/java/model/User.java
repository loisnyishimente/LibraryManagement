package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User extends Person {
    private String username;
    private String password; // Storing hashed password
    private String role;
    private Membership membership; // Changed to use Membership enum
    private int borrowedBooks;
    private int fine;

    public User(String phone, String username, String password, Membership membership1, String role, Membership membership) {
        super(phone);
        this.username = username;
        setPassword(password); // Hash password upon creation
        this.role = role;
        this.membership = membership; // Set membership
        this.borrowedBooks = 0;
        this.fine = 0;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public Membership getMembership() {
        return membership; // Return the Membership enum
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void incrementBorrowedBooks() {
        this.borrowedBooks++;
    }

    public void decrementBorrowedBooks() {
        this.borrowedBooks--;
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

    public String getPassword() {
        return null;
    }

    // Removed getPassword method since it's not necessary and exposes sensitive data
}
