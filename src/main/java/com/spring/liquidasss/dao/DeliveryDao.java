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
