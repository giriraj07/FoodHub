package org.giriraj.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.giriraj.Model.Restaurant;

public interface IRestaurant extends JpaRepository<Restaurant, Long> {

}
