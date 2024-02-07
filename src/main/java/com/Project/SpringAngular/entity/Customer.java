package com.Project.SpringAngular.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@Column(name = "customer_id",length = 50)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerid;
	
	@Column(name = "customer_name",length = 50)
	private String customername;
	
	@Column(name = "customer_address",length = 60)
	private String customeraddress;
	
	@Column(name = "mobile",length = 12)
	private String mobile;
	
	public Customer(int customerid, String customername,String customeraddress, String mobile) {
		this.customerid = customerid;
		this.customername = customername;
		this.customeraddress = customeraddress;
		this.mobile = mobile;
	}
	
	public Customer() {
		
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	public String getCustomeraddress() {
		return customeraddress;
	}
	
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress  =customeraddress;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", customeraddress="
				+ customeraddress + ", mobile=" + mobile + "]";
	}
	
	
}
