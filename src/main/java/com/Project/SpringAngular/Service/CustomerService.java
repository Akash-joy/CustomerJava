package com.Project.SpringAngular.Service;


import java.util.List;
import java.util.Optional;

import com.Project.SpringAngular.entity.Customer;

public interface CustomerService {

	String addCustomer(Customer customer);
	Optional<Customer> getCustomer(int customerid);
	Optional<Customer> putCustomer(int customerid, Customer updatedCustomer);
	 boolean deleteCustomer(int customerid);
	 List<Customer> getAllCustomers();
	 void deleteAllCustomers();
}
