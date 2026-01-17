package com.spring.liquidasss.dao;

import com.spring.liquidasss.models.Delivery;
import lombok.Setter;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Setter
@Repository
public class DeliveryDao {

    private SessionFactory sessionFactory;

    @Transactional
    public Delivery addDelivery(Delivery delivery){
        this.sessionFactory.getCurrentSession().save(delivery);
        return delivery;
    }

    @Transactional
    public List<Delivery> getDeliveries(Delivery delivery){
        return this.sessionFactory
                .getCurrentSession()
                .createQuery("FROM DELIVERY")
                .list();
    }

    @Transactional
    public Delivery getDelivery(int id){
        return this.sessionFactory.getCurrentSession().get(Delivery.class, id);
    }

    public Delivery updateDelivery(Delivery delivery){
        this.sessionFactory.getCurrentSession().update();
    }

}
