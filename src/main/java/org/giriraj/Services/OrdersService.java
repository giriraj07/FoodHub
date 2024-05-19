package org.giriraj.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.giriraj.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.giriraj.Exceptions.NotAvailableException;
import org.giriraj.Exceptions.NotFoundException;
import org.giriraj.Repository.IOrders;

@Service
public class OrdersService implements IOrdersService {

	@Autowired
	private IOrders orders;
	@Autowired
	private IRiderService dp;
	
	@Override
	public Orders create(Orders r) {
		// TODO Auto-generated method stub
		return orders.save(r);
	}

	@Override
	public Orders update(Orders r) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(r.getOrderId());
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		
		return orders.save(r);
	}

	@Override
	public Orders updateOrderStatus(Status s,Long id) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		Orders o=opt.get();
		o.setOrderStatus(s);
		return orders.save(o);
	}

	@Override
	public List<Orders> viewAll() {
		// TODO Auto-generated method stub
		return orders.findAll();
	}

	@Override
	public Orders viewById(Long id) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		return opt.get();
	}

	@Override
	public List<Orders> viewByCustomerId(Long id) {
		// TODO Auto-generated method stub
		List<Orders> opt=orders.findAll();
		List<Orders> cid=new ArrayList<Orders>();
		for(Orders i:opt) {
			if(i.getCustomer().getUserId().equals(id)) {
				cid.add(i);
			}
		}
		return cid;
	}

	@Override
	public Orders delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Orders> opt=orders.findById(id);
		if(!opt.isPresent()) {
			throw new NotFoundException("Not Found Exception");
		}
		orders.deleteById(id);
		return opt.get();
	}

	@Override
	public Orders assignToRider(Long did, Long oid) {
	
		Optional<Orders> opt=orders.findById(oid);
		if(!opt.isPresent()) {
			throw new NotFoundException("No Orders Found with id");
		}
		Rider dps=dp.isPresent(did);
		
		if(dps.getStatus().equals(Condition.ENGAGED)) {
			throw new NotAvailableException("Not available");
		}
		if(opt.get().getOrderStatus().equals(Status.DELIVERED) || opt.get().getOrderStatus().equals(Status.ON_THE_WAY)) {
			throw new NotAvailableException("Already Assigned");
		}
		Orders order= opt.get();
		order.setRider(dps);
		dps.setStatus(Condition.ENGAGED);
		
		
		return orders.save(order);
	}

}
