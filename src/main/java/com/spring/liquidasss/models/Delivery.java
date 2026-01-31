package com.spring.liquidasss.models;

import com.spring.liquidasss.enums.TypeOfVehicle;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;

@Entity
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TypeOfVehicle getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(TypeOfVehicle typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public DeliveryUserId getDeliveryUserId() {
        return deliveryUserId;
    }

    public void setDeliveryUserId(DeliveryUserId deliveryUserId) {
        this.deliveryUserId = deliveryUserId;
    }
}
