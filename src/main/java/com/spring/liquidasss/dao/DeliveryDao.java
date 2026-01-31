package com.spring.liquidasss.dao;

import com.spring.liquidasss.models.Delivery;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DeliveryDao {

    private SessionFactory sessionFactory;

    @Autowired
    public DeliveryDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public Delivery addDelivery(Delivery delivery){
        this.sessionFactory.getCurrentSession().save(delivery);
        return delivery;
    }

    @Transactional
    public List<Delivery> getDeliveries(){
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("FROM DELIVERY")
                .list();
    }

    @Transactional
    public void updateDelivery(Delivery delivery){
        this.sessionFactory.getCurrentSession().update(delivery);
    }

    @Transactional
    public void deleteDelivery(Delivery delivery){
        this.sessionFactory.getCurrentSession().detach(delivery);
    }
}
