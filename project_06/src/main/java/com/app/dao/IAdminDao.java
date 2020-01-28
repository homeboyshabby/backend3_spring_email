package com.app.dao;
import java.util.List;

import com.app.pojos.*;
public interface IAdminDao {
	List<Orders> getOnlineOrderStatus();
	Employee authEmployee(String email,String password) throws Exception;
	void addMenuItem(MenuItems m) throws Exception;
	List<Employee> showAllEmployees() throws Exception;
	Employee getEmployee(Integer id) throws Exception;
	Long getCurrentCountOfChairs();
	void addTable(DiningTable d);
	List<OrderDetails> getOrderDetails(int id);
	void addEmployee(Employee e, String role);
	void changeOrderStatus(int orderId);
}
