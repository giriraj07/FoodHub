package org.giriraj.Controller;

import java.util.List;

import org.giriraj.Model.Rider;
import org.giriraj.Services.IRiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class RiderController {

	@Autowired
	IRiderService riderService;
	
	@GetMapping("/Riders")
	public ResponseEntity<List<Rider>> getAllCustomers(){
		return new ResponseEntity<List<Rider>>(riderService.viewAll(),HttpStatus.OK);
	}
	@GetMapping("/Rider/{id}")
	public ResponseEntity<Rider> getCustomerById(@Valid@PathVariable Long id){
		return new ResponseEntity<Rider>(riderService.viewById(id),HttpStatus.OK);
	}
	@PostMapping("/RiderAdd")
	public ResponseEntity<Rider> addCustomer(@Valid@RequestBody Rider c){
		return new ResponseEntity<Rider>(riderService.create(c),HttpStatus.OK);
	}
	@PutMapping("/RiderUpdate")
	public ResponseEntity<Rider> updateCustomer(@Valid@RequestBody Rider c){
		return new ResponseEntity<Rider>(riderService.update(c),HttpStatus.OK);
	}
	@DeleteMapping("/RiderDelete/{id}")
	public ResponseEntity<Rider> updateCustomer(@Valid@PathVariable Long id){
		return new ResponseEntity<Rider>(riderService.delete(id),HttpStatus.OK);
	}
}
