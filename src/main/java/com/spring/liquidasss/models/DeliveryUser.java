package com.spring.liquidasss.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
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


}
