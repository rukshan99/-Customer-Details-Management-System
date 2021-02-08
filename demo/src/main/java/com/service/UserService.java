package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.model.User;

public interface UserService {
	
	public Page<User> findAll(Pageable pageable);
	public Optional<User> findById(Long id);
	public void add(User user);
	public Optional<User> update(User user);
	public Optional<User> delete(Long id);
	public List<User> findByCriteria(String criteria, String searchItem);

}
