package org.giriraj.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.giriraj.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	
	Optional<User> findByuserName(String userName);
}
