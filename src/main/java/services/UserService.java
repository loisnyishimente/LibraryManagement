package services;

import dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String phone, String username, String email, String membershipType) throws Exception {
        // Add registration logic, e.g., check for existing users and save new user
        if (userDao.existsByEmail(email)) {
            throw new Exception("Email already registered.");
        }
        userDao.saveUser(phone, username, email, membershipType);
    }
}
