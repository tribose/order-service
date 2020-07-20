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
	private String customerName;
	
	@Column(name="ORDER_DATE")
	private String orderDate;
	
	@Column(name="SHIPPING_ADDRESS")
	@NotEmpty(message = "Shipping Address can't be empty")
	private String shippingAddress;

	@OneToMany(mappedBy="orderElement", fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Product> orderItems = new ArrayList<>();
	
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

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public List<Product> getOrderItems() {
		return orderItems;
	}

	public void setOrderItems(List<Product> orderItems) {
		this.orderItems = orderItems;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderNumber=" + orderNumber + ", customerName=" + customerName
				+ ", orderDate=" + orderDate + ", shippingAddress=" + shippingAddress + ", orderItems=" + orderItems
				+ ", total=" + total + "]";
	}
}
