package org.giriraj.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.giriraj.Model.Customer;
import org.giriraj.Services.ICustomerSevice;

import jakarta.validation.Valid;

import java.util.Collections;
import java.util.List;


@RestController	
@RequestMapping("/cus")
public class CustomerController {

	@Autowired
	ICustomerSevice customerService;

//	@Autowire
//	private PasswordEncoder pc;
	public static final Logger log = LoggerFactory.getLogger(CustomerController.class);
	@GetMapping("/Customers")
	public ResponseEntity<Page<Customer>> getAllCustomers(){
        log.info("Getting all customers");
        
		return new ResponseEntity<>(customerService.viewAll(),HttpStatus.OK);
	}
	@GetMapping("/Customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@Valid@PathVariable Long id){
		log.info("Getting Customer by Id");
		
		return new ResponseEntity<>(customerService.viewCustomerById(id),HttpStatus.OK);
	}
	@PostMapping("/CustomerAdd")
	public ResponseEntity<Customer> addCustomer(@Valid@RequestBody Customer c){
		log.info("Adding a Customer");
		
		return new ResponseEntity<>(customerService.AddCustomer(c),HttpStatus.OK);
	}
	@PutMapping("/CustomerUpdate")
	public ResponseEntity<Customer> updateCustomer(@Valid@RequestBody Customer c){
		log.info("Modify a Customer");
		return new ResponseEntity<>(customerService.UpdateCustomer(c),HttpStatus.OK);
	}
	@DeleteMapping("/CustomerDelete/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid@PathVariable Long id){
		log.info("Deleting the customer");
		return new ResponseEntity<>(customerService.DeleteCustomer(id),HttpStatus.OK);
	}
	
	
}
