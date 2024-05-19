package org.giriraj.Controller;

import java.util.List;

import org.giriraj.Services.CustomerHistory;
import org.giriraj.Services.RiderHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.giriraj.Model.Orders;
import org.giriraj.Services.IOrdersService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/history")
public class HistoryController {

    @Autowired
    IOrdersService oService;

    @Autowired
    CustomerHistory customerHistory;

    @Autowired
    RiderHistory riderHistory;

    @GetMapping("/Orders")
    public ResponseEntity<List<Orders>> getAllOrders(){
        return new ResponseEntity<List<Orders>>(oService.viewAll(), HttpStatus.OK);
    }
    @GetMapping("/Customer/{id}")
    public ResponseEntity<List<Orders>> getOrderPlaced(@Valid @PathVariable Long id){
        return new ResponseEntity<List<Orders>>(customerHistory.getAllOrdersPlaced(id),HttpStatus.OK);
    }

    @GetMapping("/Rider/{id}")
    public ResponseEntity<List<Orders>> getOrderDelivered(@Valid @PathVariable Long id){
        return new ResponseEntity<List<Orders>>(riderHistory.getAllOrdersDelivered(id),HttpStatus.OK);
    }

}
