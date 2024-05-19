package org.giriraj.Services;

import java.util.List;

import org.giriraj.Model.FoodType;
import org.giriraj.Model.Restaurant;

public interface IRestaurantService {
	

	public Restaurant create(Restaurant r);
	public Restaurant update(Restaurant r);
	public List<Restaurant> viewAll(String field,String direction);
	public Restaurant viewById(Long id);
	public Restaurant delete(Long id);
	public List<Restaurant> findByFoodType(FoodType foodType);
}
