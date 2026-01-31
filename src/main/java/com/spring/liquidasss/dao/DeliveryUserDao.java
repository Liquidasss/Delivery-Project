package com.spring.liquidasss.dao;

import com.spring.liquidasss.models.Delivery;
import com.spring.liquidasss.models.DeliveryUser;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class DeliveryUserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public DeliveryUserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public DeliveryUser addDeliveryUser(DeliveryUser deliveryUser){
        this.sessionFactory.getCurrentSession().save(deliveryUser);
        return deliveryUser;
    }

    @Transactional
    public List<DeliveryUser> getDeliveryUsers(){
        return this.sessionFactory.getCurrentSession().createQuery("from DELIVERY_USER").list();
    }

    @Transactional
    public List<Delivery> getDeliveryByUserID(Integer user_id){
        String sql = "SELECT product_id FROM cart_product WHERE cart_id = :cart_id";
        List<Integer> deliveryIds = this.sessionFactory.getCurrentSession()
                .createNativeQuery(sql)
                .setParameter("user_id", user_id)
                .list();

        sql = "SELECT * FROM delivery WHERE id IN (:delivery_ids)";
        return this.sessionFactory.getCurrentSession()
                .createNativeQuery(sql, Delivery.class)
                .setParameterList("delivery_ids", deliveryIds)
                .list();
    }

    @Transactional
    public void updateDeliveryUser(DeliveryUser deliveryUser){
        this.sessionFactory.getCurrentSession().update(deliveryUser);
    }

    @Transactional
    public void deleteDeliveryUser(DeliveryUser deliveryUser){
        this.sessionFactory.getCurrentSession().delete(deliveryUser);
    }

}
