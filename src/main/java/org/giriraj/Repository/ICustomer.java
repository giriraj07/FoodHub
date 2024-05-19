package org.giriraj.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.giriraj.Model.Customer;

public interface ICustomer extends JpaRepository<Customer,Long >,PagingAndSortingRepository<Customer, Long> {

//	public Optional<Customer> findByemail(String email);
    public List<Customer> findAll();
}
