package com.dbs.order.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "order-item-service")
public interface OrderServiceProxy {
	
	@GetMapping("/order/item")
	public String getOrderItem();
}
