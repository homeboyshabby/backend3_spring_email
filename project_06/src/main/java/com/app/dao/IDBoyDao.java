package com.app.dao;

import java.util.List;

import com.app.pojos.Orders;

public interface IDBoyDao {
	List<Orders> getOnlineOrderStatus();
	List<Orders> getPendingOnlineOrderStatus();
	List<Orders> getDeliveredOnlineOrderStatus();
	void changeOrderStatus(int orderId);
}
