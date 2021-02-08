package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByUserName(String username);

	public List<User> findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

	public List<User> findByAge(Integer age);

	public List<User> findByCountry(String country);
}
