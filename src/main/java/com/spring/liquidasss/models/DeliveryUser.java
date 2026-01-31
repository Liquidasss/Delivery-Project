package com.spring.liquidasss.models;

import jakarta.persistence.*;

@Entity
@Table(name = "DELIVERY_USER")
public class DeliveryUser {

    @EmbeddedId
    private DeliveryUserId id;

    @ManyToOne
    @MapsId("deliveryId")
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    public DeliveryUser() {}

    public DeliveryUser(DeliveryUserId id, Delivery delivery, User user) {
        this.id = id;
        this.delivery = delivery;
        this.user = user;
    }

    public DeliveryUserId getId() {
        return id;
    }

    public void setId(DeliveryUserId id) {
        this.id = id;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



