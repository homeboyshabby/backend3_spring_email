package com.app.pojos;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "menu_items")
public class MenuItems {
	private Integer itemId;
	private String itemName;
	private String itemDesc;
	private double itemPrice;
	//private OrderItem orderedItemId;
	//private OrderDetails details;
	public MenuItems() {
		// TODO Auto-generated constructor stub
	}
	public MenuItems(String itemName, String itemDesc, double itemPrice) {
		this.itemName = itemName;
		this.itemDesc = itemDesc;
		this.itemPrice = itemPrice;
	}
	public MenuItems(Integer id) {
		this.itemId = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id")
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	@Column(name = "item_name")
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	@Column(name = "item_desc")
	public String getItemDesc() {
		return itemDesc;
	}
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	@Column(name = "item_price")
	public double getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}
//	@Transient
//	@JsonIgnore
//	@ManyToOne
//	@JoinTable(name = "item_details")
//	public OrderDetails getDetails() {
//		return details;
//	}
//	public void setDetails(OrderDetails details) {
//		this.details = details;
//	}
//	@Transient
//	@ManyToOne
//	public OrderItem getOrderedItemId() {
//		return orderedItemId;
//	}
//	public void setOrderedItemId(OrderItem orderedItemId) {
//		this.orderedItemId = orderedItemId;
//	}
	@Override
	public String toString() {
		return "MenuItems [itemId=" + itemId + ", itemName=" + itemName + ", itemDesc=" + itemDesc + ", itemPrice="
				+ itemPrice + "]";
	}
	
}
