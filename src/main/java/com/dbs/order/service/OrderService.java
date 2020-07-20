package com.dbs.order.service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dbs.order.exception.OrderItemNotFoundException;
import com.dbs.order.exception.OrderNotFoundException;
import com.dbs.order.model.OrderEntity;
import com.dbs.order.model.OrderItem;
import com.dbs.order.model.Product;
import com.dbs.order.proxy.OrderServiceProxy;
import com.dbs.order.repository.OrderRepository;

import feign.FeignException;

@Service
public class OrderService {

	
	  @Autowired 
	  OrderRepository orderRepository;
	  
	  @Autowired 
	  OrderServiceProxy orderServiceProxy;
	  
	  @Value("${orderitem.decrement.count}") 
	  private int decrementCount;
	  
	  public List<OrderEntity> getAllOrder() throws OrderNotFoundException{ 
		  List<OrderEntity> orderList = orderRepository.findAll();
		  System.out.println("getAllOrder : "+orderList);
		  if(orderList.size() > 0) {
			  return orderList; 
		  }
		  else { 
			  throw new OrderNotFoundException("Order Not Found. Please create an order or try something else");
		  } 
	  }
	  
	  public OrderEntity getOrderByOrderNumber(long orderNumber) throws OrderNotFoundException {
	  
		  Optional<OrderEntity> order = orderRepository.findByOrderNumber(orderNumber);
		  if(order.isPresent()) { 
			  return order.get(); 
		  }else { 
			  throw new OrderNotFoundException("Order Not Found. Please try something else"); 
		  } 
	  }
	 
	
	public OrderEntity createOrder(OrderEntity orderEntity) throws OrderItemNotFoundException {
			
		for(Product product : orderEntity.getOrder_item()) {
			String productName = product.getProductName();
			try {
				OrderItem orderItem = orderServiceProxy.getOrderItemByProductName(productName);
				System.out.println("Order Items "+ orderItem);
				if(orderItem.getQuantity() < product.getCount()) {
					throw new OrderItemNotFoundException("Requested order quantity for "+product.getProductName() +" is more than available quantity of "+orderItem.getQuantity());
				}
			}catch(FeignException ex) {
				throw new OrderItemNotFoundException(ex.getMessage());
			}
			
		}
		orderEntity.setOrderNumber(ThreadLocalRandom.current().nextLong(5000000, 5050000));
		for(Product product : orderEntity.getOrder_item()) {
			product.setOrderElement(orderEntity);
		}
		
		orderEntity = orderRepository.save(orderEntity);
		for(Product product : orderEntity.getOrder_item()) {
			String productName = product.getProductName();
			try {
				OrderItem orderItem = orderServiceProxy.getOrderItemByProductName(productName);
				int orderItemQuantity = orderItem.getQuantity() - product.getCount();
				orderItem.setQuantity(orderItemQuantity);
				orderServiceProxy.updateOrderItem(orderItem);
			}catch(FeignException ex) {
				throw new OrderItemNotFoundException(ex.getMessage());
			}
		}
		return orderEntity;
	}
}
