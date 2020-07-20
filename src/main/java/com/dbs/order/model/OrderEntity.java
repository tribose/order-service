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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_ORDER")
@Getter
@Setter
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

	

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", orderNumber=" + orderNumber + ", customerName=" + customerName
				+ ", orderDate=" + orderDate + ", shippingAddress=" + shippingAddress + ", orderItems=" + orderItems
				+ ", total=" + total + "]";
	}
}
