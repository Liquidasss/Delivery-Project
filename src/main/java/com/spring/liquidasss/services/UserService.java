package com.spring.liquidasss.services;

import com.spring.liquidasss.dao.UserDao;
import com.spring.liquidasss.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public List<User> getUsers(){
        return this.userDao.getAllUsers();
    }

    public User addUser(User user) {
        try {
            user.setRole("USER");
            return this.userDao.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Add user error");
        }
    }

    public boolean checkUserExists(String username) {
        return this.userDao.userExists(username);
    }

    public User getUserByEmail(String username) {
        return userDao.getUserByUsername(username);
    }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

}
