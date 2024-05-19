package org.giriraj.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Restaurant {

	@NotNull
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long restaurantId;
	
	@NotNull
	private String restaurantName;
	
	@NotNull
	private String address;
	
	@OneToMany(mappedBy="restaurant")
	private List<Orders> orders;

	@NotNull
	@Enumerated(EnumType.STRING)
	private FoodType foodType;

	public Restaurant(String restaurantName, String address) {
		super();
		this.restaurantName = restaurantName;
		this.address = address;
	}

	public Restaurant() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", address="
				+ address + "]";
	}
	
	
}
