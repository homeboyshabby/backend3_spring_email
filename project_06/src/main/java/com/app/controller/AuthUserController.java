package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IAdminDao;
import com.app.dao.ICustomerDao;
import com.app.pojos.Customer;
import com.app.pojos.Employee;

@RestController
@CrossOrigin
@RequestMapping("/auth")
public class AuthUserController {
	@Autowired
	private ICustomerDao custDao;
	@Autowired
	private IAdminDao adminDao;
	@PostMapping("/cust")
	public ResponseEntity<?> authCustomer(@RequestBody Customer c) throws Exception {
		Customer cust = custDao.authenticateUser(c.getEmail(), c.getPassword());
		if (cust != null)
			return new ResponseEntity<Customer>(cust, HttpStatus.OK);
		return new ResponseEntity<String>("Invalid Login", HttpStatus.NO_CONTENT);
	}
	@PostMapping("/emp")
	public ResponseEntity<?> authEmployee(@RequestBody Employee e) throws Exception {
		Employee emp = adminDao.authEmployee(e.getEmployeeEmail(), e.getEmployeePassword());
		if (emp != null)
			return new ResponseEntity<Employee>(emp, HttpStatus.OK);
		return new ResponseEntity<String>("Invalid Login", HttpStatus.NO_CONTENT);
	}
}
