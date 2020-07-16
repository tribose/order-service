package com.dbs.order.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TBL_ORDER")
public class OrderEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
    private Long id;
	
	@Column(name="CUSTOMER_NAME")
	@NotEmpty(message = "Customer name can't be empty")
	private String customer_name;
	
	@Column(name="ORDER_DATE")
	private String order_date;
	
	@Column(name="SHIPPING_ADDRESS")
	@NotEmpty(message = "Shipping address can't be empty")
	private String shipping_address;
	
	@Column(name="ORDER_ITEM")
	@NotEmpty(message = "Order Item can't be empty")
	private String order_item;
	
	@Column(name="TOTAL")
	private float total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getOrder_date() {
		return order_date;
	}

	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public String getOrder_item() {
		return order_item;
	}

	public void setOrder_item(String order_item) {
		this.order_item = order_item;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "Order_Entity [id=" + id + ", customer_name=" + customer_name + ", order_date=" + order_date
				+ ", shipping_address=" + shipping_address + ", order_item=" + order_item + ", total=" + total + "]";
	}
}
