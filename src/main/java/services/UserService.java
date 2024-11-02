package services;

import dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(String userName, String password, String role, String villageId) throws Exception {
        // Check if the username is already taken
        if (userDao.existsByName(userName)) {
            throw new Exception("Username already taken.");
        }

        // Save the new user with all required fields
        userDao.saveUser(userName, password, role, villageId);
    }
}
