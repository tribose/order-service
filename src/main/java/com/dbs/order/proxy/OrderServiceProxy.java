package com.dbs.order.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.dbs.order.exception.OrderItemNotFoundException;
import com.dbs.order.model.OrderItem;

import feign.FeignException;

@FeignClient(name = "order-item-service")
public interface OrderServiceProxy {

	@GetMapping("/items/product/{productName}")
	public OrderItem getOrderItemByProductName(@PathVariable("productName") String productName)	throws OrderItemNotFoundException, FeignException;

	
	  @PostMapping("/items") 
	  public OrderItem updateOrderItem(@RequestBody OrderItem orderItem);
	 
}
