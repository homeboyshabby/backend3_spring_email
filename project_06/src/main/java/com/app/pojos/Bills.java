package com.app.pojos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Table(name = "bills")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Bills {
	private Integer billId;
	private double billAmt;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date billDate;
	private double billDisc;
	private Orders order;
	public Bills() {
		// TODO Auto-generated constructor stub
	}
	public Bills(double billAmt, Date billDate, double billDisc) {
		super();
		this.billAmt = billAmt;
		this.billDate = billDate;
		this.billDisc = billDisc;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bill_id")
	public Integer getBillId() {
		return billId;
	}
	public void setBillId(Integer billId) {
		this.billId = billId;
	}
	@Column(name = "bill_amt")
	public double getBillAmt() {
		return billAmt;
	}
	public void setBillAmt(double billAmt) {
		this.billAmt = billAmt;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "bill_date")
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	@Column(name = "bill_disc")
	public double getBillDisc() {
		return billDisc;
	}
	public void setBillDisc(double billDisc) {
		this.billDisc = billDisc;
	}
	//@JsonIgnore
	@OneToOne
	@JoinColumn(name = "order_id")
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Bills [billId=" + billId + ", billAmt=" + billAmt + ", billDate=" + billDate + ", billDic=" + billDisc
				+ "]";
	}
	
}
//private Integer billId;
//private List<Orders> orders = new ArrayList<>();
//@DateTimeFormat(pattern="yyyy-MM-dd")
//private Date billDate;
//private double billAmt;
//private double billDiscount;
//public Bills() {
//	// TODO Auto-generated constructor stub
//}
//public Bills(List<Orders> orders, Date billDate, double billAmt, double billDiscount) {
//	super();
//	this.orders = orders;
//	this.billDate = billDate;
//	this.billAmt = billAmt;
//	this.billDiscount = billDiscount;
//}
//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//@Column(name = "bill_id")
//public Integer getBillId() {
//	return billId;
//}
//public void setBillId(Integer billId) {
//	this.billId = billId;
//}
//@OneToMany
//@Column(name = "order_id")
//public List<Orders> getOrders() {
//	return orders;
//}
//public void setOrders(List<Orders> orders) {
//	this.orders = orders;
//}
//@Temporal(TemporalType.DATE)
//@Column(name = "bill_date")
//public Date getBillDate() {
//	return billDate;
//}
//public void setBillDate(Date billDate) {
//	this.billDate = billDate;
//}
//@Column(name = "bill_amt")
//public double getBillAmt() {
//	return billAmt;
//}
//public void setBillAmt(double billAmt) {
//	this.billAmt = billAmt;
//}
//@Column(name = "bill_disc")
//public double getBillDiscount() {
//	return billDiscount;
//}
//public void setBillDiscount(double billDiscount) {
//	this.billDiscount = billDiscount;
//}
//@Override
//public String toString() {
//	return "Bills [billId=" + billId + ", orders=" + orders + ", billDate=" + billDate + ", billAmt=" + billAmt
//			+ ", billDiscount=" + billDiscount + "]";
//}
