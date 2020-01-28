package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IWaiterDao;
import com.app.pojos.Customer;
import com.app.pojos.DiningTable;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;

@RestController
@CrossOrigin
@RequestMapping("/waiter")
public class WaiterController {
	@Autowired
	private IWaiterDao waiterDao;
	
	@GetMapping("/tables")
	public ResponseEntity<?> getAllCustomers()
	{
		List<DiningTable> listOfTables = waiterDao.checkTableStatus();
		if(listOfTables == null)
			return new ResponseEntity<String> ("No Data Found",HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<DiningTable>> (listOfTables,HttpStatus.OK);
	}
	@GetMapping("/menu")
	public ResponseEntity<?> getAllMenu()
	{
		List<MenuItems> menu = waiterDao.showMenu();
		if(menu == null)
			return new ResponseEntity<String> ("No Data Found",HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<MenuItems>> (menu,HttpStatus.OK);
	}
	
	@GetMapping("/setorder")
	public ResponseEntity<?> setOrderId() {
		 //System.out.println(id);
		Orders order = waiterDao.getOrderId();
		// System.out.println(listOfOrders);
		if (order == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
	
	@PostMapping("/addorderdetails")
	public ResponseEntity<?> addOrderDetails(@RequestBody OrderDetails o) {
		System.out.println(o);
		try {
			waiterDao.addOrderDetails(o);
			return new ResponseEntity<String>("Added", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Not Added", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
