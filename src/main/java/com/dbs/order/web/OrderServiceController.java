package com.dbs.order.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.exception.OrderItemNotFoundException;
import com.dbs.order.exception.OrderNotFoundException;
import com.dbs.order.model.OrderEntity;
import com.dbs.order.service.OrderService;

@RestController
@RequestMapping("/orders")
@Validated
public class OrderServiceController {

	@Autowired
	OrderService orderService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON) 
	public List<OrderEntity> getAllOrder() throws OrderNotFoundException{
  
		return orderService.getAllOrder(); 
	}
  
	@GetMapping(value = "/{orderNumber}", produces = MediaType.APPLICATION_JSON)
	public OrderEntity  getOrderbyOrderNumber(@NotNull @PathVariable("orderNumber") long orderNumber) throws OrderNotFoundException {
  
		return orderService.getOrderByOrderNumber(orderNumber); 
	}
	 
	
	@PostMapping(produces = MediaType.APPLICATION_JSON)
	public OrderEntity createOrder(@Valid @RequestBody OrderEntity order) throws OrderItemNotFoundException, RuntimeException{
		
		OrderEntity orderResponse = orderService.createOrder(order);
		System.out.println("orderResponse :"+orderResponse);
		return orderResponse;
	}
}
