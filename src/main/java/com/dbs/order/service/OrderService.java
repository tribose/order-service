package com.dbs.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.order.exception.OrderNotFoundException;
import com.dbs.order.model.OrderEntity;
import com.dbs.order.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	public List<OrderEntity> getAllOrder(){
		List<OrderEntity> orderList = orderRepository.findAll();
		
		if(orderList.size() > 0) {
			return orderList;
		}else {
			return new ArrayList<OrderEntity>();
		}	
	}
	
	public OrderEntity getOrderById(Long id) throws OrderNotFoundException {
		
		Optional<OrderEntity> order = orderRepository.findById(id);
		if(order.isPresent()) {
			return order.get();
		}else {
			throw new OrderNotFoundException("Order Not Found. Please try something else");
		}
	}
	
	public OrderEntity createOrUpdateOrder(OrderEntity orderEntity) {
		
		Optional<OrderEntity> order = orderRepository.findById(orderEntity.getId());
		if(order.isPresent()) {
			OrderEntity newOrder = order.get();
			newOrder.setCustomer_name(orderEntity.getCustomer_name());
			newOrder.setOrder_date(orderEntity.getOrder_date());
			newOrder.setShipping_address(orderEntity.getShipping_address());
			newOrder.setTotal(orderEntity.getTotal());
			
			newOrder = orderRepository.save(newOrder);
			return newOrder;
		}else {
			orderEntity = orderRepository.save(orderEntity);
			return orderEntity;
		}
	}
}