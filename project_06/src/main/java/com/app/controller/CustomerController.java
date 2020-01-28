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

import com.app.dao.ICustomerDao;
import com.app.pojos.Bills;
import com.app.pojos.Customer;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Reservation;
import com.sun.org.apache.xpath.internal.operations.Or;

@RestController
@CrossOrigin
@RequestMapping("/cust")
public class CustomerController {
	@Autowired
	private ICustomerDao custDao;

	@GetMapping("/myorders/{id}")
	public ResponseEntity<?> getMyOrders(@PathVariable int id) {
		// System.out.println(id);
		List<Orders> listOfOrders = custDao.showAllOrders(id);
		System.out.println(listOfOrders);
		if (listOfOrders == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Orders>>(listOfOrders, HttpStatus.OK);
	}

	@GetMapping("/myprofile/{id}")
	public ResponseEntity<?> getMyProfile(@PathVariable int id) {
		// System.out.println(id);
		Customer cust = custDao.getMyDetails(id);
		// System.out.println(listOfOrders);
		if (cust == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}

	@PostMapping("/setmyprofile")
	public ResponseEntity<?> getMyProfile(@RequestBody Customer c) {
		if (custDao.setMyDetails(c))
			return new ResponseEntity<String>("Updated Successfully", HttpStatus.OK);
		return new ResponseEntity<String>("Update Failed", HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> changeMyPassword(@RequestBody Customer c) {
		if (custDao.chnageMyPassword(c.getEmail(), c.getPassword(), c.getNewpassword()))
			return new ResponseEntity<String>("Password Changed Successfully", HttpStatus.OK);
		return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/myreservations")
	public ResponseEntity<?> getMyReservations(@RequestBody Customer c) {
		List<Reservation> list = custDao.getMyReservations(c.getId());
		if (list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Reservation>>(list, HttpStatus.OK);
	}

	@PostMapping("/deletemyreservation")
	public ResponseEntity<?> deleteMyReservation(@RequestBody Reservation r) {
		if (custDao.deleteMyReservation(r.getResId()))
			return new ResponseEntity<String>("Reservation Deleted!", HttpStatus.NO_CONTENT);
		return new ResponseEntity<String>("Reservation Not Deleted!", HttpStatus.OK);
	}

	@PostMapping("/orderonline")
	public ResponseEntity<?> orderOnline(@RequestBody MenuItems menu) {
		//System.out.println(menu);
		MenuItems m = custDao.getSelectedMenu(menu.getItemDesc());
		if (m == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<MenuItems>(m, HttpStatus.OK);
	}

	@PostMapping("/addmyreservation/{id}")
	public ResponseEntity<?> addMyReservation(@RequestBody Reservation r,@PathVariable int id) {
		try {
			custDao.addMyReservations(r,id);
			return new ResponseEntity<String>("Reserved", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Not Reserved", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@GetMapping("/setorder/{id}")
	public ResponseEntity<?> setOrderId(@PathVariable int id) {
		 //System.out.println(id);
		Orders order = custDao.getOrderId(id);
		// System.out.println(listOfOrders);
		if (order == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<Orders>(order, HttpStatus.OK);
	}
	@PostMapping("/addorderdetails/{id}")
	public ResponseEntity<?> addOrderDetails(@RequestBody OrderDetails o,@PathVariable int id) {
		System.out.println(o);
		try {
			custDao.addOrderDetails(o,id);
			return new ResponseEntity<String>("Added", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Not Added", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@PostMapping("/genratebill")
	public ResponseEntity<?> generateBill(@RequestBody Bills b) {
		System.out.println(b);
		try {
			custDao.generateBill(b);
			return new ResponseEntity<String>("Added", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Not Added", HttpStatus.NOT_ACCEPTABLE);
		}
	}
}
