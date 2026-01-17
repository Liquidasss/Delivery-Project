package com.spring.liquidasss.services;

import com.spring.liquidasss.dao.DeliveryDao;
import com.spring.liquidasss.models.Delivery;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DeliveryService {

    private DeliveryDao deliveryDao;

    public Delivery addDelivery(Delivery delivery){
        return deliveryDao.addDelivery(delivery);
    }

    public List<Delivery> getDeliveries() {
        return this.deliveryDao.getDeliveries();
    }

    public void updateDelivery(Delivery delivery) {
        deliveryDao.updateDelivery(delivery);
    }

    public void deleteDelivery(Delivery delivery) {
        deliveryDao.deleteDelivery(delivery);
    }

}
