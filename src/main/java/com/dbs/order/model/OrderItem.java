package com.dbs.order.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderItem {

    private Long id;
	private String productCode;
	private String productName;
	private int quantity;
}
