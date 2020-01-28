package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Bills;
import com.app.pojos.Customer;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderStatus;
import com.app.pojos.OrderType;
import com.app.pojos.Orders;
import com.app.pojos.Reservation;
import com.app.pojos.UserType;

@Repository
@Transactional
public class CustomerDaoImpl implements ICustomerDao {
	@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<Customer> getCustomers() {
		String jpql = "select cust from Customer cust left outer join fetch cust.orders"
				+ " left outer join fetch cust.orderDetails";
		return mgr.unwrap(Session.class).createQuery(jpql, Customer.class).getResultList();
	}	
	
	@Override
	public List<Customer> getCurrentCustomers() {
		String jpql = "select cust from Customer cust";
		return mgr.unwrap(Session.class).createQuery(jpql, Customer.class).getResultList();
	}
	
	@Override
	public void addCustomer(Customer c) {
		mgr.unwrap(Session.class).persist(c);
	}

//	@Override
//	public Customer getCustomersAllDetails(int cid) {
//		Customer cust = mgr.unwrap(Session.class).load(Customer.class, cid);
//		//Hibernate.initialize(cust.getOrderDetails());
//		//System.out.println(cust);
//		return cust;
//	}
	
	public Customer getCustomersAllDetails(int cid) {
		String jpql = "select cust from Customer cust left outer join fetch cust.orders"
				+ " left outer join fetch cust.orderDetails where cust.id = :id";
		return mgr.unwrap(Session.class).createQuery(jpql, Customer.class).setParameter("id", cid).getSingleResult();
	}

	@Override
	public Customer authenticateUser(String email, String password) throws Exception {
		String jpql = "select c from Customer c where c.email = :email and c.password = :password";
		return mgr.unwrap(Session.class).createQuery(jpql, Customer.class).setParameter("email", email)
				.setParameter("password", password).getSingleResult();

	}

	public List<Orders> showAllOrders(int custId) {
		// System.out.println(custId);
		String jpql = "select o from Orders o where o.custId.id = :id";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).setParameter("id", custId).getResultList();
	}

	@Override
	public Customer getMyDetails(int cid) {
		return mgr.unwrap(Session.class).get(Customer.class, cid);
	}

	@Override
	public Boolean setMyDetails(Customer c) {
		try {
			String email = c.getEmail();
			String jpql = "select c from Customer c where c.email  = :email";
			Customer currentUser = mgr.unwrap(Session.class).createQuery(jpql, Customer.class).setParameter("email", email)
					.getSingleResult();
			currentUser.setName(c.getName());
			currentUser.setPhoneNumber(c.getPhoneNumber());
			currentUser.setCustAddress(c.getAddress().getFlatNo(), c.getAddress().getBuildingName(),
					c.getAddress().getArea(), c.getAddress().getCity());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public Boolean chnageMyPassword(String email, String oldPass, String newPass) {
		try {
			String jpql = "select c from Customer c where c.email = :email and c.password = :oldpass";
			Customer c = mgr.unwrap(Session.class).createQuery(jpql, Customer.class).setParameter("email", email)
					.setParameter("oldpass", oldPass).getSingleResult();
			c.setPassword(newPass);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Reservation> getMyReservations(int custId) {
		String jpql = "select r from Reservation r where r.custId.id = :id";
		return mgr.unwrap(Session.class).createQuery(jpql, Reservation.class).setParameter("id", custId).getResultList();
	}

	@Override
	public Boolean deleteMyReservation(int resId) {
		try {
			mgr.unwrap(Session.class).remove(mgr.unwrap(Session.class).get(Reservation.class, resId));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MenuItems getSelectedMenu(String menuName) {
		try
		{
			System.out.println(menuName);
			String jpql = "select m from MenuItems m where m.itemDesc = :name";
			return mgr.unwrap(Session.class).createQuery(jpql,MenuItems.class).setParameter("name", menuName).getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void addMyReservations(Reservation r,int id) {
		r.setCustId(new Customer(id));
		mgr.unwrap(Session.class).persist(r);
	}

	@Override
	public Orders getOrderId(int custId) {
		Orders order = new Orders(new Date(System.currentTimeMillis()),OrderType.valueOf("HOMEDELIVERY"),OrderStatus.valueOf("PENDING"));
		order.setCustId(new Customer(custId));
		System.err.println(order.toString());
		mgr.unwrap(Session.class).persist(order);
		//String jpql = "select o from Orders o where o.custId.id = :id";
		String jpql = "select o from Orders o where o.orderId = (select MAX(o.orderId) from o) ";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).getSingleResult();
	}

	@Override
	public void addOrderDetails(OrderDetails o,int id) {
		o.setCustId(new Customer(id));
		mgr.unwrap(Session.class).persist(o);	
	}

	@Override
	public void generateBill(Bills b) {
		b.setBillDate(new Date(System.currentTimeMillis()));
		mgr.unwrap(Session.class).persist(b);
	}

}
//"select cust from Customer cust join fetch cust.reservations r join fetch cust.orders o where cust.custId = :cid";
