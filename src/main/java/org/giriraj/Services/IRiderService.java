package org.giriraj.Services;


import org.giriraj.Model.Rider;

import java.util.List;

public interface IRiderService {

	public Rider create(Rider r);
	public Rider update(Rider r);
	public Rider isPresent(Long id);
	public List<Rider> viewAll();
	public Rider viewById(Long id);
	public Rider delete(Long id);
}
