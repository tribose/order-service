package com.dbs.order.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.order.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{

	public Optional<OrderEntity> findByOrderNumber(Long orderNumber);
}
