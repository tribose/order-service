package com.dbs.order.web;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;
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
	public List<OrderEntity> getAllOrder(){
		
		return orderService.getAllOrder();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public OrderEntity getOrderbyId(@PathVariable @Min(value = 1, message = "id must be greater than or equal to 1") Long id) throws OrderNotFoundException {
		
		return orderService.getOrderById(id);
	}
	
	@PostMapping
	public OrderEntity createOrUpdateOrder(@Valid @RequestBody OrderEntity order) throws OrderItemNotFoundException{
		
		System.out.println("orderEntity.toString() :"+order.toString());
		OrderEntity orderResponse = orderService.createOrUpdateOrder(order);
		return orderResponse;
	}
}
