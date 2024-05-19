package org.giriraj.Services;

import java.util.List;

import org.giriraj.Model.Orders;
import org.giriraj.Model.Status;



public interface IOrdersService {

	public Orders create(Orders r);
	public Orders updateOrderStatus(Status s,Long id);
	public Orders assignToRider(Long did,Long oid);
	public List<Orders> viewAll();
	public Orders viewById(Long id);
	public List<Orders> viewByCustomerId(Long id);
	public Orders delete(Long id);
	

}
