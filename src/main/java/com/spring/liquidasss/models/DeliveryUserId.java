package com.spring.liquidasss.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryUserId implements Serializable {

    @Column(name = "delivery_id")
    private Integer deliveryId;

    @Column(name = "user_id")
    private Integer userId;

}
