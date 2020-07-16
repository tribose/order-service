package com.dbs.order.web;

import java.util.List;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.order.exception.OrderNotFoundException;
import com.dbs.order.model.OrderEntity;
import com.dbs.order.proxy.OrderServiceProxy;
import com.dbs.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderServiceController {

	@Autowired
	OrderServiceProxy orderServiceProxy;
	
	@Autowired
	OrderService orderService;
	
	@GetMapping("/hello")
	public String hello() {
		return orderServiceProxy.getOrderItem();
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON)
	public List<OrderEntity> getAllOrder(){
		
		return orderService.getAllOrder();
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON)
	public OrderEntity getOrderbyId(@PathVariable("id") Long id) throws OrderNotFoundException {
		
		return orderService.getOrderById(id);
	}
	
	@PostMapping
	public OrderEntity createOrUpdateOrder(@RequestBody OrderEntity order) {
		System.out.println("orderEntity.toString() :"+order.toString());
		OrderEntity orderResponse = orderService.createOrUpdateOrder(order);
		return orderResponse;
	}
}
