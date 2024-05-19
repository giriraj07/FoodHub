package org.giriraj.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.giriraj.Exceptions.NotFoundException;
import org.giriraj.Model.DeliveryPartner;
import org.giriraj.Repository.IDeliveryPartner;

@Service
public class DeliveryPartnerImpl implements IDeliveryPartnerService {

	@Autowired
	private IDeliveryPartner idp;

	@Override
	public DeliveryPartner create(DeliveryPartner r) {
		// TODO Auto-generated method stub
		return idp.save(r);
	}

	@Override
	public DeliveryPartner update(DeliveryPartner r) {
		// TODO Auto-generated method stub
		Optional<DeliveryPartner> dp = idp.findById(r.getDeliveryPartnerId());

		if (!dp.isPresent()) {
			throw new NotFoundException("DeliveryPartner not Found Exception");
		}

		return idp.save(r);
	}

	@Override
	public List<DeliveryPartner> viewAll() {
		// TODO Auto-generated method stub
		return idp.findAll();
	}

	@Override
	public DeliveryPartner viewById(Long id) {
		// TODO Auto-generated method stub
		Optional<DeliveryPartner> dp = idp.findById(id);

		return dp.orElseThrow(() -> new NotFoundException("No DeliveryPartner found"));
	}

	@Override
	public DeliveryPartner delete(Long id) {
		// TODO Auto-generated method stub
		Optional<DeliveryPartner> dp = idp.findById(id);
		
		idp.deleteById(id);
		return dp.get();
	}

	@Override
	public DeliveryPartner isPresent(Long id) {
		// TODO Auto-generated method stub
		Optional<DeliveryPartner> dp = idp.findById(id);
		
		return dp.orElseThrow(() -> new NotFoundException("No DeliveryPartner found"));
	}

}
