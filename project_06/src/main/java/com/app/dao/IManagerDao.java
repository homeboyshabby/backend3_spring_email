package com.app.dao;
import java.util.List;

import com.app.pojos.*;
public interface IManagerDao {
	List<Bills> getAllBills();
	List<Integer> getOrderIdForHomeDeliverySaleReport();
	List<Double> getOrderAmtForSaleReport(int id);
	List<Integer> getOrderIdForDineInSaleReport();
}
