package com.spring.liquidasss.services;

import com.spring.liquidasss.dao.UserDao;
import com.spring.liquidasss.models.User;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserDao userDao;

    public List<User> getUsers(){
        return this.userDao.getAllUsers();
    }

    public User addUser(User user) {
        try {
            return this.userDao.saveUser(user);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("Add user error");
        }
    }

    public boolean checkUserExists(String username) {
        return this.userDao.userExists(username);
    }

    public User getUserByUsername(String email) {
        return userDao.getUserByEmail(email);
    }

}
