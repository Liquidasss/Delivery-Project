package com.spring.liquidasss.dao;

import lombok.*;
import com.spring.liquidasss.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
@Repository
public class UserDao {

    private SessionFactory sessionFactory;

    @Transactional
    public User addUser(User user){
        this.sessionFactory.getCurrentSession().save(user);
        return user;
    }

    @Transactional
    public List<User> getUsers(){
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("from USERS")
                .list();
    }

    @Transactional
    public void updateUser(User user){
        this.sessionFactory.getCurrentSession().update(user);
    }

    @Transactional
    public void deleteUser(User user){
        this.sessionFactory.getCurrentSession().delete(user);
    }

}
