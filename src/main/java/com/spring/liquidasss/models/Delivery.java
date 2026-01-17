package com.spring.liquidasss.models;

import com.spring.liquidasss.enums.TypeOfVehicle;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String email;

    @Enumerated(EnumType.STRING)
    private TypeOfVehicle typeOfVehicle;

    @OneToMany(mappedBy = "delivery")
    private List<Product> products;

    private double weight;

    @Embedded
    private DeliveryUserId deliveryUserId;

}
