package com.Project.SpringAngular.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.SpringAngular.CustomerRepo.CustomerRepo;
import com.Project.SpringAngular.entity.Customer;


@Service
public class CustomerServiceIMPL implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;
	
	@Override
	public String addCustomer(Customer customer) {
	
		Customer customer1 = new Customer(
				
			    0,customer.getCustomername(),
			    customer.getCustomeraddress(),
			    customer.getMobile()
				);
		    
		customerRepo.save(customer1);
		return customer1.getCustomername();
	}

	@Override
	public Optional<Customer> getCustomer(int customerid) {
	    Optional<Customer> customer123 = customerRepo.findById(customerid);
	    return customer123;
	}
	 @Override
	    public boolean deleteCustomer(int customerid) {
	        if (customerRepo.existsById(customerid)) {
	            customerRepo.deleteById(customerid);
	            return true;
	        }
	        return false;
	    }
	
	 @Override
	    public Optional<Customer> putCustomer(int customerid, Customer updatedCustomer) {
	        Optional<Customer> existingCustomer = customerRepo.findById(customerid);
	        if (existingCustomer.isPresent()) {
	            // Update the fields of the existing customer with the values from the updatedCustomer
	            Customer customerToUpdate = existingCustomer.get();
	            customerToUpdate.setCustomername(updatedCustomer.getCustomername());
	            customerToUpdate.setCustomeraddress(updatedCustomer.getCustomeraddress());
	            customerToUpdate.setMobile(updatedCustomer.getMobile());

	            // Save the updated customer
	            customerRepo.save(customerToUpdate);
	        }
	        return existingCustomer;
	    }

	  @Override
	    public List<Customer> getAllCustomers() {
	        return customerRepo.findAll();
	    }
	  @Override
	    public void deleteAllCustomers() {
	        customerRepo.deleteAll();
	    }

}

