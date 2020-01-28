//package com.app.pojos;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//
//@Entity
//@Table(name = "order_item_details")
//public class OrderItem {
//	private Integer oIId;
//	private OrderDetails details;
//	private List<MenuItems> items = new ArrayList<>();
//	public OrderItem() {
//		// TODO Auto-generated constructor stub
//	}
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name = "order_item_id")
//	public Integer getoIId() {
//		return oIId;
//	}
//	public void setoIId(Integer oIId) {
//		this.oIId = oIId;
//	}
//	@OneToOne
//	@Column(name = "order_details_id")
//	public OrderDetails getDetails() {
//		return details;
//	}
//	public void setDetails(OrderDetails details) {
//		this.details = details;
//	}
//	@JsonIgnore
//	@OneToMany(mappedBy = "")
//	@Column(name = "order_item_id")
//	public List<MenuItems> getItems() {
//		return items;
//	}
//	public void setItems(List<MenuItems> items) {
//		this.items = items;
//	}
//	@Override
//	public String toString() {
//		return "OrderItem [oIId=" + oIId + ", details=" + details + ", items=" + items + "]";
//	}
//	
//}
