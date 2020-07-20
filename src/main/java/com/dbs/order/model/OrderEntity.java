package com.dbs.order.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TBL_ORDER")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Column(name="ORDER_NUMBER")
	private long orderNumber;	
	
	@Column(name="CUSTOMER_NAME")
	@NotEmpty(message = "Customer name can't be empty")
	private String customer_name;
	
	@Column(name="ORDER_DATE")
	private String order_date;
	
	@Column(name="SHIPPING_ADDRESS")
	@NotEmpty(message = "Shipping Address can't be empty")
	private String shipping_address;

	@OneToMany(mappedBy="orderElement", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Product> order_item = new ArrayList<>();
	
	@Column (name="TOTAL")
	@NotNull(message = "Total amount can't be empty")
	private float total;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
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

	public List<Product> getOrder_item() {
		return order_item;
	}

	public void setOrder_item(List<Product> order_item) {
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
		return "OrderEntity [id=" + id + ", orderNumber=" + orderNumber + ", customer_name=" + customer_name
				+ ", order_date=" + order_date + ", shipping_address=" + shipping_address + ", order_item=" + order_item
				+ ", total=" + total + "]";
	}
}
