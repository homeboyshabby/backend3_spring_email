package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "dining_table")
public class DiningTable {
	private Integer tableId;
	private String tableStatus;
	private int noOfChairs;
	public DiningTable() {
		// TODO Auto-generated constructor stub
	}
	public DiningTable(String tableStatus, int noOfChairs) {
		super();
		this.tableStatus = tableStatus;
		this.noOfChairs = noOfChairs;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_id")
	public Integer getTableId() {
		return tableId;
	}
	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}
	@Column(name = "table_status",length = 20)
	public String getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(String tableStatus) {
		this.tableStatus = tableStatus;
	}
	@Column(name = "table_chairs")
	public int getNoOfChairs() {
		return noOfChairs;
	}
	public void setNoOfChairs(int noOfChairs) {
		this.noOfChairs = noOfChairs;
	}
	@Override
	public String toString() {
		return "DiningTable [tableId=" + tableId + ", tableStatus=" + tableStatus + ", noOfChairs=" + noOfChairs + "]";
	}
	
	
}
