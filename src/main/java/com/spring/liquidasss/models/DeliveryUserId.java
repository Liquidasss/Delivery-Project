package com.spring.liquidasss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DeliveryUserId implements Serializable {

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "user_id")
    private Integer userId;

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof DeliveryUserId that)) return false;
        return Objects.equals(deliveryId, that.deliveryId) && Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryId, userId);
    }
}
