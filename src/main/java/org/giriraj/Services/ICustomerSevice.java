package org.giriraj.Services;

import org.giriraj.Model.Customer;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ICustomerSevice {

	public Customer AddCustomer(Customer c);
	public Customer UpdateCustomer(Customer C);
	public Page<Customer> viewAll();
	public Customer viewCustomerById(Long id);
	public Customer DeleteCustomer(Long id);
}
