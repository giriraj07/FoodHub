package org.giriraj.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.giriraj.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
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
	@Autowired
	private CustomerHistory customerHistory;
	@Autowired
	private RiderHistory riderHistory;
	
	@Override
	public Orders create(Orders r) {
		// TODO Auto-generated method stub
		customerHistory.addOrders(r.getCustomer().getCustomerId(), r);
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
		if(s.equals(Status.DELIVERED))
			riderHistory.addOrdersDelivered(o.getRider().getRiderId(), o);
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
	public Orders assignToRider(Long rid, Long oid) {
	
		Optional<Orders> opt=orders.findById(oid);
		if(!opt.isPresent()) {
			throw new NotFoundException("No Orders Found with id");
		}
		Rider dps=dp.isPresent(rid);
		if(opt.get().getOrderStatus().equals(Status.DELIVERED)){
			riderHistory.addOrdersDelivered(rid, opt.get());
			throw new NotAvailableException("Already Delivered");
		}
		if(dps.getStatus().equals(Condition.ENGAGED)) {
			throw new NotAvailableException("Not available");
		}
		if(opt.get().getOrderStatus().equals(Status.ON_THE_WAY)) {
			throw new NotAvailableException("Already Delivered");
		}
		Orders order= opt.get();
		order.setRider(dps);
		dps.setStatus(Condition.ENGAGED);
		
		
		return orders.save(order);
	}

}
