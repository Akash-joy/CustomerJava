package com.Project.SpringAngular.CustomerController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.SpringAngular.Service.CustomerService;
import com.Project.SpringAngular.entity.Customer;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping(path = "/save")
	public String saveCustomer(@RequestBody Customer customer) {
		
		String name = customerService.addCustomer(customer);
		return name;
		
	}
	
	@GetMapping(path = "/get")
	public Optional<Customer> getCustomer(@RequestParam int customerid) {
	    Optional<Customer> customerdet = customerService.getCustomer(customerid);
	    return customerdet;
	}
	 @PutMapping(path = "/put/{customerid}")
	    public Optional<Customer> putCustomer(@PathVariable int customerid, @RequestBody Customer updatedCustomer) {
	        Optional<Customer> customerdet = customerService.putCustomer(customerid, updatedCustomer);
	        return customerdet;
	    }
	 @DeleteMapping(path = "/delete/{customerid}")
	    public String deleteCustomer(@PathVariable int customerid) {
	        boolean deleted = customerService.deleteCustomer(customerid);
	        return deleted ? "Customer deleted successfully" : "Customer not found or couldn't be deleted";
	    }
	 @GetMapping(path = "/getall")
	    public List<Customer> getAllCustomers() {
	        return customerService.getAllCustomers();
	    }

	    @DeleteMapping(path = "/deleteall")
	    public String deleteAllCustomers() {
	        customerService.deleteAllCustomers();
	        return "All customers deleted successfully";
	    }

}
