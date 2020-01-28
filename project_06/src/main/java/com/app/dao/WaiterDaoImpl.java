package com.app.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.pojos.Customer;
import com.app.pojos.DiningTable;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.OrderType;
import com.app.pojos.Orders;

@Repository
@Transactional
public class WaiterDaoImpl implements IWaiterDao {
	@PersistenceContext
	private EntityManager mgr;
	@Override
	// a = table available
	//na = table not available
	public List<DiningTable> checkTableStatus() {
		String jpql = "select d from DiningTable d";
		return mgr.unwrap(Session.class).createQuery(jpql,DiningTable.class).getResultList();
	}
	@Override
	public List<MenuItems> showMenu() {
		String jpql = "select i from MenuItems i";
		return mgr.unwrap(Session.class).createQuery(jpql,MenuItems.class).getResultList();
	}
	@Override
	public void takeOrder() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Orders getOrderId() {
		Orders order = new Orders(new Date(System.currentTimeMillis()),OrderType.valueOf("DINEIN"));
		//order.setCustId(new Customer(custId));
		//System.err.println(order.toString());
		mgr.unwrap(Session.class).persist(order);
		//String jpql = "select o from Orders o where o.custId.id = :id";
		String jpql = "select o from Orders o where o.orderId = (select MAX(o.orderId) from o) ";
		return mgr.unwrap(Session.class).createQuery(jpql, Orders.class).getSingleResult();
	}
	
	@Override
	public void addOrderDetails(OrderDetails o) {
		mgr.unwrap(Session.class).persist(o);	
	}


}
