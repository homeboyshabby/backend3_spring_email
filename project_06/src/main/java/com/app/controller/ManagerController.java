package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.IManagerDao;
import com.app.pojos.Bills;
import com.app.pojos.Orders;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {
	@Autowired
	private IManagerDao managerDao;
	
	@GetMapping("/bills")
	public ResponseEntity<?> getAllBills() {
		// System.out.println(id);
		List<Bills> listOfBills = managerDao.getAllBills();
		//System.out.println(listOfOrders);
		if (listOfBills == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Bills>>(listOfBills, HttpStatus.OK);
	}
	
	@GetMapping("/getorderidhd")
	public ResponseEntity<?> getOrderIdForHomeDeliverySaleReport() {
		// System.out.println(id);
		List<Integer> listOfId = managerDao.getOrderIdForHomeDeliverySaleReport();
		//System.out.println(listOfOrders);
		if (listOfId == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Integer>>(listOfId, HttpStatus.OK);
	}
	@GetMapping("/getorderiddi")
	public ResponseEntity<?> getOrderIdForDineInSaleReport() {
		// System.out.println(id);
		List<Integer> listOfId = managerDao.getOrderIdForDineInSaleReport();
		//System.out.println(listOfOrders);
		if (listOfId == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Integer>>(listOfId, HttpStatus.OK);
	}
	@GetMapping("/getorderid/{id}")
	public ResponseEntity<?> getOrderAmtForHomeDeliverySaleReport(@PathVariable int id) {
		// System.out.println(id);
		List<Double> total = managerDao.getOrderAmtForSaleReport(id);
		//System.out.println(listOfOrders);
		if (total == null)
			return new ResponseEntity<String>("No Data Found", HttpStatus.NO_CONTENT);
		return new ResponseEntity<List<Double>>(total, HttpStatus.OK);
	}
}
