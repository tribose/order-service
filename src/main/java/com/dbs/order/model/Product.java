package com.dbs.order.model;

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

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="TBL_PRODUCT")
@Getter
@Setter
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
	@Getter(value = AccessLevel.NONE)
	private OrderEntity orderElement;

	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", count=" + count
				+ "]";
	}	
}
