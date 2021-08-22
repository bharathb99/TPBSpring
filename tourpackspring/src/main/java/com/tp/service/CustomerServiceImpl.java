package com.tp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tp.dao.CustomerDao;
import com.tp.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	@Override
	public void createCustomer(Customer customer) {
		
		customerDao.createCustomer(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
	
		return customerDao.getAllCustomers();
	}

//	@Override
//	public Customer getCustomer(Customer customer) {
//		
//		return customerDao.getCustomer(customer);
//	}
	
	@Override
	public Customer getCustomer(String email) {
		
		return customerDao.getCustomer(email);
	}

	@Override
	public List<Customer> updateCustomer(Customer customer) {
		
		return customerDao.updateCustomer(customer);
	}

	@Override
	public List<Customer> deleteCustomer(int cno) {
		
		return customerDao.deleteCustomer(cno);
	}

	@Override
	public Customer getCustomerById(int cid) {
		
		return customerDao.getCustomerById(cid);
	}

}
