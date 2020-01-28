package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Bills;
import com.app.pojos.Customer;
import com.app.pojos.DiningTable;
import com.app.pojos.Employee;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderStatus;
import com.app.pojos.Orders;
import com.app.pojos.UserType;

@Repository
@Transactional
public class AdminDaoImpl implements IAdminDao {
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<Orders> getOnlineOrderStatus() {
		String jpql = "select o from Orders o";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).getResultList();
	}

	@Override
	public Employee authEmployee(String email, String password) throws Exception {
		String jpql = "select e from Employee e where e.employeeEmail = :email and e.employeePassword = :password";
		return mgr.unwrap(Session.class).createQuery(jpql, Employee.class).setParameter("email", email)
				.setParameter("password", password).getSingleResult();
	}

	@Override
	public void addMenuItem(MenuItems m) throws Exception {
		mgr.unwrap(Session.class).persist(m);
	}

	@Override
	public List<Employee> showAllEmployees() throws Exception {
		String jpql = "select e from Employee e where e.role = '"+ UserType.valueOf("MANAGER") + "' or e.role= '"+ UserType.valueOf("WAITER") + "' or e.role= '"+ UserType.valueOf("DELIVERYBOY") + "'";
		return mgr.unwrap(Session.class).createQuery(jpql,Employee.class).getResultList();
	}

	@Override
	public Employee getEmployee(Integer id) throws Exception {
		return mgr.unwrap(Session.class).get(Employee.class, id);
	}

	@Override
	public Long getCurrentCountOfChairs() {
		String jpql = "select count(d.tableId) from DiningTable d";
		return mgr.unwrap(Session.class).createQuery(jpql,Long.class).getSingleResult();
	}

	@Override
	public void addTable(DiningTable d) {
		d.setTableStatus("Available");
		mgr.unwrap(Session.class).persist(d);
	}

	@Override
	public List<OrderDetails> getOrderDetails(int id) {
		String jpql = "select o from OrderDetails o where o.orderId.orderId = :id";
		return mgr.unwrap(Session.class).createQuery(jpql,OrderDetails.class).setParameter("id", id).getResultList();
	}

	@Override
	public void addEmployee(Employee e, String role) {
		e.setRole(UserType.valueOf(role));
		mgr.unwrap(Session.class).persist(e);	
	}

	@Override
	public void changeOrderStatus(int orderId) {
		mgr.unwrap(Session.class).get(Orders.class, orderId).setStatus(OrderStatus.valueOf("OUTFORDELIVERY"));
	}

	
}
