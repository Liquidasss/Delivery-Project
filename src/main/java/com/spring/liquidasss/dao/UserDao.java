package com.spring.liquidasss.dao;

import lombok.*;
import com.spring.liquidasss.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
@Repository
public class UserDao {

    private SessionFactory sessionFactory;

    @Transactional
    public List<User> getAllUsers(){
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from CUSTOMER").list();
        return userList;
    }

    @Transactional
    public User saveUser(User user){
        this.sessionFactory.getCurrentSession().saveOrUpdate(user);
        return user;
    }

    @Transactional
    public User getUser(String email, String password){
        Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where email = :email");
        query.setParameter("email", email);

        try{
            User user = (User) query.getSingleResult();
            if(password.equals(user.getPassword())){
                return user;
            }else{
                return new User();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            User user = new User();
            return user;
        }
    }

    @Transactional
    public boolean userExists(String email){
        Query query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where email = :email");
        query.setParameter("email",email);
        return !query.getResultList().isEmpty();
    }

    @Transactional
    public User getUserByEmail(String email){
        Query<User> query = sessionFactory.getCurrentSession().createQuery("from CUSTOMER where email = :email", User.class);
        query.setParameter("email",email);

        try {
            return query.getSingleResult();
            }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
