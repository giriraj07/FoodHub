package org.giriraj.Services;

import java.util.List;

import org.giriraj.Model.DeliveryPartner;

public interface IDeliveryPartnerService {

	public DeliveryPartner create(DeliveryPartner r);
	public DeliveryPartner update(DeliveryPartner r);
	public DeliveryPartner isPresent(Long id);
	public List<DeliveryPartner> viewAll();
	public DeliveryPartner viewById(Long id);
	public DeliveryPartner delete(Long id);
}
