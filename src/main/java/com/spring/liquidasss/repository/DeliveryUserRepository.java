package com.spring.liquidasss.repository;

import com.spring.liquidasss.models.DeliveryUser;
import com.spring.liquidasss.models.DeliveryUserId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeliveryUserRepository extends JpaRepository<DeliveryUser, DeliveryUserId> {
}
