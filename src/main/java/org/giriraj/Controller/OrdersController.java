package org.giriraj.Controller;

import org.giriraj.Model.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.giriraj.Model.Orders;
import org.giriraj.Services.IOrdersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrdersController {

	@Autowired
	IOrdersService oService;

	@GetMapping("/Orders/{id}")
	public ResponseEntity<Orders> getOrderById(@Valid@PathVariable Long id){
		return new ResponseEntity<Orders>(oService.viewById(id),HttpStatus.OK);
	}
	@PostMapping("/OrderAdd")
	public ResponseEntity<Orders> addOrder(@Valid@RequestBody Orders c){
		return new ResponseEntity<Orders>(oService.create(c),HttpStatus.OK);
	}
	@PutMapping("/OrderUpdate")
	public ResponseEntity<Orders> updateOrder(@Valid@RequestBody Orders c, @RequestParam Status status){
		return new ResponseEntity<Orders>(oService.updateOrderStatus(status, c.getOrderId()),HttpStatus.OK);
	}
	@DeleteMapping("/OrderDelete/{id}")
	public ResponseEntity<Orders> updateOrder(@Valid@PathVariable Long id){
		return new ResponseEntity<Orders>(oService.delete(id),HttpStatus.OK);
	}
}
