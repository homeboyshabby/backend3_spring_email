package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "order_details")
public class OrderDetails {
	private Integer orderDetailsId;
	private int orderItemQty;
	private double orderItemAmt;
	private Customer custId;
	private Orders orderId;
	private MenuItems itemId;
	private DiningTable tableId;
	public OrderDetails() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetails(int orderItemQty, double orderItemAmt) {
		super();
		this.orderItemQty = orderItemQty;
		this.orderItemAmt = orderItemAmt;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderdetails_id")
	public Integer getOrderDetailsId() {
		return orderDetailsId;
	}
	public void setOrderDetailsId(Integer orderDetailsId) {
		this.orderDetailsId = orderDetailsId;
	}
	@Column(name = "orderitem_qty")
	public int getOrderItemQty() {
		return orderItemQty;
	}
	public void setOrderItemQty(int orderItemQty) {
		this.orderItemQty = orderItemQty;
	}
	@Column(name = "orderitem_amt")
	public double getOrderItemAmt() {
		return orderItemAmt;
	}
	public void setOrderItemAmt(double orderItemAmt) {
		this.orderItemAmt = orderItemAmt;
	}
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustId() {
		return custId;
	}
	public void setCustId(Customer custId) {
		this.custId = custId;
	}
	@ManyToOne
	@JoinColumn(name = "order_id")
	public Orders getOrderId() {
		return orderId;
	}
	public void setOrderId(Orders orderId) {
		this.orderId = orderId;
	}
	@ManyToOne
	@JoinColumn(name = "item_id")
	public MenuItems getItemId() {
		return itemId;
	}
	public void setItemId(MenuItems itemId) {
		this.itemId = itemId;
	}
	@OneToOne
	@JoinColumn(name = "table_id")
	public DiningTable getTableId() {
		return tableId;
	}
	public void setTableId(DiningTable tableId) {
		this.tableId = tableId;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderDetailsId=" + orderDetailsId + ", orderItemQty=" + orderItemQty + ", orderItemAmt="
				+ orderItemAmt + ", custId=" + custId + ", orderId=" + orderId + "]";
	}
	
}
