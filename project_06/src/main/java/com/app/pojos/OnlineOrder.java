package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_online")
public class OnlineOrder {
	private Integer id;
	private int itemId;
	private int itemQty;
	public OnlineOrder() {
		// TODO Auto-generated constructor stub
	}
	public OnlineOrder(int itemId, int itemQty) {
		super();
		this.itemId = itemId;
		this.itemQty = itemQty;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "onlineorder_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	@Column(name = "item_id")
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	@Column(name = "item_qty")
	public int getItemQty() {
		return itemQty;
	}
	public void setItemQty(int itemQty) {
		this.itemQty = itemQty;
	}
	@Override
	public String toString() {
		return "OnlineOrder [id=" + id + ", itemId=" + itemId + ", itemQty=" + itemQty + "]";
	}
	
}
