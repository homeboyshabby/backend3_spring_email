package com.app.pojos;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "reservations")
public class Reservation {
	private Integer resId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date resDate;
	private int resNumberOfPeople;
	private String resDetails;
	private Customer custId;
	private DiningTable tableId;
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	public Reservation(Date resDate, int resNumberOfPeople, String resDetails) {
		super();
		this.resDate = resDate;
		this.resNumberOfPeople = resNumberOfPeople;
		this.resDetails = resDetails;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "res_id")
	public Integer getResId() {
		return resId;
	}
	public void setResId(Integer resId) {
		this.resId = resId;
	}
	@Column(name = "res_date")
	public Date getResDate() {
		return resDate;
	}
	public void setResDate(Date resDate) {
		this.resDate = resDate;
	}
	@OneToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustId() {
		return custId;
	}
	public void setCustId(Customer custId) {
		this.custId = custId;
	}
	@OneToOne
	@JoinColumn(name = "table_id")
	public DiningTable getTableId() {
		return tableId;
	}
	public void setTableId(DiningTable tableId) {
		this.tableId = tableId;
	}
	@Column(name = "res_people")
	public int getResNumberOfPeople() {
		return resNumberOfPeople;
	}

	public void setResNumberOfPeople(int resNumberOfPeople) {
		this.resNumberOfPeople = resNumberOfPeople;
	}
	@Column(name = "res_details")
	public String getResDetails() {
		return resDetails;
	}

	public void setResDetails(String resDetails) {
		this.resDetails = resDetails;
	}

	@Override
	public String toString() {
		return "Reservation [resId=" + resId + ", resDate=" + resDate + "]";
	}
}