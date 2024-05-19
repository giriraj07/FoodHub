package org.giriraj.Repository;

import java.util.List;

import org.giriraj.Model.Restaurant;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.data.jpa.repository.JpaRepository;

import org.giriraj.Model.Orders;

public interface IOrders extends JpaRepository<Orders, Long> {

//	public List<Orders> findByCustomerId(Long Id);
}
