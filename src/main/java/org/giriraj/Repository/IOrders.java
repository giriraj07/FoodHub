package org.giriraj.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import org.giriraj.Model.Orders;

public interface IOrders extends JpaRepository<Orders, Long> {

//	public List<Orders> findByCustomerId(Long Id);
}
