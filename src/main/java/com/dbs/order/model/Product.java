package com.dbs.order.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TBL_PRODUCT")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="PRODUCT_NAME")
	@NotEmpty(message = "Product name can't be empty")
	private String productName;
	
	@Column(name="PRODUCT_COUNT")
	@NotNull(message = "Product count can't be empty")
	private int count;
	
	@ManyToOne
	@JoinColumn(name="ORDER_ID", nullable=false)
	private OrderEntity orderElement;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public void setOrderElement(OrderEntity orderElement) {
		this.orderElement = orderElement;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", count=" + count
				+ "]";
	}	
}
