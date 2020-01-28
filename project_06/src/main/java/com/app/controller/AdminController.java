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
import com.app.pojos.Customer;
import com.app.pojos.DiningTable;
import com.app.pojos.Employee;
import com.app.pojos.MenuItems;
import com.app.pojos.OrderDetails;
import com.app.pojos.Orders;
import com.app.pojos.Reservation;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ICustomerDao custDao;
	@Autowired
	private IAdminDao adminDao;

	@GetMapping("/customers")
	public ResponseEntity<?> getAllCustomers() {
		List<Customer> listOfCustomers = custDao.getCurrentCustomers();
		if (listOfCustomers == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Customer>>(listOfCustomers, HttpStatus.OK);
	}

	@PostMapping
	public void registerNewCustomer(@RequestBody Customer c) {
		custDao.addCustomer(c);
	}

	@GetMapping("/getcustorders/{no}")
	public ResponseEntity<?> getCustomersOrderDetails(@PathVariable int no) {
		List<Orders> list = custDao.showAllOrders(no);
		if(list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
	}
	@GetMapping("/getcustreservations/{no}")
	public ResponseEntity<?> getCustomersReservationDetails(@PathVariable int no) {
		List<Reservation> list = custDao.getMyReservations(no);
		if(list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Reservation>>(list, HttpStatus.OK);
	}

	@GetMapping("/orderdetails")
	public ResponseEntity<?> getOnlineOrderDetails() {
		List<Orders> list = adminDao.getOnlineOrderStatus();
		if (list == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Orders>>(list, HttpStatus.OK);
	}

	@PostMapping("/addmenu")
	public ResponseEntity<?> addMenuItem(@RequestBody MenuItems m) {
		System.out.println(m);
		try {
			adminDao.addMenuItem(m);
			return new ResponseEntity<String>("Menu Added", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Menu Not Added", HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/showemp")
	public ResponseEntity<?> showEmployees() {
		try {
			List<Employee> list = adminDao.showAllEmployees();
			if (list != null)
				return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
	}
	@GetMapping("/getemp/{id}")
	public ResponseEntity<?> getEmployee(@PathVariable int id) {
		try {
			Employee e = adminDao.getEmployee(id);
			if (e != null)
				return new ResponseEntity<Employee>(e, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
	}
	@GetMapping("/tablecount")
	public ResponseEntity<?> getCurrentTableCount() {
		try {
			Long e = adminDao.getCurrentCountOfChairs();
			if (e != null)
				return new ResponseEntity<Long>(e, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Not Found", HttpStatus.NOT_FOUND);
	}
	@PostMapping("/addtable")
	public ResponseEntity<?> addTable(@RequestBody DiningTable d) {
		try {
			adminDao.addTable(d);
			return new ResponseEntity<String>("Table Added", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Table Not Added", HttpStatus.NOT_ACCEPTABLE);
	}
	@GetMapping("/getorderdetails/{id}")
	public ResponseEntity<?> addTable(@PathVariable int id) {
		try {
			List<OrderDetails> list =  adminDao.getOrderDetails(id);
			if(list != null)
				return new ResponseEntity<List<OrderDetails>>(list, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Details Not Found", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping("/addemp/{role}")
	public ResponseEntity<?> addTable(@RequestBody Employee emp,@PathVariable String role) {
		try {
			adminDao.addEmployee(emp, role);
			return new ResponseEntity<String>("Emp Added", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Emp Not Added", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping("/changeorderstatus/{id}")
	public ResponseEntity<?> changeOrderStatus(@PathVariable int id) {
		try {
			adminDao.changeOrderStatus(id);
			return new ResponseEntity<String>("Order Status Changed", HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Order Status Not Changed", HttpStatus.NOT_ACCEPTABLE);
	}
}
