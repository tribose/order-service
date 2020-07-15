package com.dbs.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceController {

	@Autowired
	OrderServiceProxy orderServiceProxy;
	
	@GetMapping("/hello")
	public String hello() {
		return orderServiceProxy.getOrderItem();
	}
	
}
