package com.app.dao;

import java.util.List;

import com.app.pojos.Bills;
import com.app.pojos.Customer;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Reservation;

public interface ICustomerDao {
	Customer authenticateUser(String email,String password) throws Exception;
	List<Customer> getCustomers();
	List<Customer> getCurrentCustomers();
	Customer getCustomersAllDetails(int cid);
	void addCustomer(Customer c);
	List<Orders> showAllOrders(int custId);
	Customer getMyDetails(int cid);
	Boolean setMyDetails(Customer c);
	Boolean chnageMyPassword(String email,String oldPass,String newPass);
	List<Reservation> getMyReservations(int custId);
	Boolean deleteMyReservation(int resId);
	MenuItems getSelectedMenu(String menuName);
	void addMyReservations(Reservation r,int id);
	Orders getOrderId(int custId);
	void addOrderDetails(OrderDetails o,int id);
	void generateBill(Bills b);
}
