package org.giriraj.Services;

import java.util.List;
import java.util.Optional;

import org.giriraj.Model.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.giriraj.Exceptions.NotFoundException;
import org.giriraj.Repository.IRider;

@Service
public class RiderService implements IRiderService {

	@Autowired
	private IRider rider;

	@Override
	public Rider create(Rider r) {
		// TODO Auto-generated method stub
		return rider.save(r);
	}

	@Override
	public Rider update(Rider r) {
		// TODO Auto-generated method stub
		Optional<Rider> dp = rider.findById(r.getRiderId());

		if (!dp.isPresent()) {
			throw new NotFoundException("Rider not Found Exception");
		}

		return rider.save(r);
	}

	@Override
	public List<Rider> viewAll() {
		// TODO Auto-generated method stub
		return rider.findAll();
	}

	@Override
	public Rider viewById(Long id) {
		// TODO Auto-generated method stub
		Optional<Rider> dp = rider.findById(id);

		return dp.orElseThrow(() -> new NotFoundException("No Rider found"));
	}

	@Override
	public Rider delete(Long id) {
		// TODO Auto-generated method stub
		Optional<Rider> dp = rider.findById(id);
		
		rider.deleteById(id);
		return dp.get();
	}

	@Override
	public Rider isPresent(Long id) {
		// TODO Auto-generated method stub
		Optional<Rider> dp = rider.findById(id);
		
		return dp.orElseThrow(() -> new NotFoundException("No Rider found"));
	}

}
