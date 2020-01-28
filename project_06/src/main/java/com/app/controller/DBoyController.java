package com.app.controller;

import java.util.ArrayList;
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

import com.app.dao.IAdminDao;
import com.app.dao.ICustomerDao;
import com.app.dao.IDBoyDao;
import com.app.pojos.Customer;
import com.app.pojos.DiningTable;
import com.app.pojos.Employee;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Reservation;

@RestController
@CrossOrigin
@RequestMapping("/dboy")
public class DBoyController {
	@Autowired
	private IDBoyDao dboyDao;

	@GetMapping("/allorders")
	public ResponseEntity<?> getOnlineOrderDetails() {
		List<Orders> list = dboyDao.getOnlineOrderStatus();
		if (list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/pendingorders")
	public ResponseEntity<?> getPendingOnlineOrderDetails() {
		List<Orders> list = dboyDao.getPendingOnlineOrderStatus();
		if (list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/deliveredorders")
	public ResponseEntity<?> getDeliveredOnlineOrderDetails() {
		System.out.println("hi");
		List<Orders> list = dboyDao.getDeliveredOnlineOrderStatus();
		if (list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/changeorderstatus/{id}")
	public ResponseEntity<?> changeOrderStatus(@PathVariable int id) {
		try {
			dboyDao.changeOrderStatus(id);
			return new ResponseEntity<String>("Order Status Changed", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Order Status Not Changed", HttpStatus.NOT_ACCEPTABLE);
	}
}
