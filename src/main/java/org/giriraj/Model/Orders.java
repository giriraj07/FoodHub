package org.giriraj.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="OrdersTable")
@Data
public class Orders {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private Long orderId;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="customer")
	private Customer customer;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="restaurant")
	private Restaurant restaurant;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="Rider")
	private Rider Rider;
	
	private List<String> items=new ArrayList<>();
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Status orderStatus;

	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Orders(Customer customerId, Restaurant restaurantId, Rider RiderId, List<String> items,
			@NotNull Status orderStatus) {
		super();
		this.customer = customerId;
		this.restaurant = restaurantId;
		this.Rider = RiderId;
		this.items = items;
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", customerId=" + customer + ", restaurantId=" + restaurant
				+ ", RiderId=" + Rider + ", items=" + items + ", orderStatus=" + orderStatus
				+ "]";
	}

	
	
}
