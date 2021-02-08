package com.component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.model.User;
import com.repository.UserRepository;

@Component
@Transactional
public class LoadUsersFromDB implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {

		if(userRepository.count() > 0) {
			return;
		}
		
		User user1 = new User("RukshanJ", UUID.randomUUID().toString(), "Rukshan", "Jayasekara", 22, "Sri Lanka");		
		User user2 = new User("LeoM", UUID.randomUUID().toString(), "Leo", "Messi", 34, "Argentina");		
		User user3 = new User("ErikaS", UUID.randomUUID().toString(), "Erika", "Santiago", 28, "USA");		
		User user4 = new User("EdnaF", UUID.randomUUID().toString(), "Edna", "Flowers", 27, "Switzerland");
		User user5 = new User("BernardW", UUID.randomUUID().toString(), "Bernard", "White", 53, "UK");
		User user6 = new User("MohammedM", UUID.randomUUID().toString(), "Mohammed", "Murakkan", 19, "Pakistan");
		User user7 = new User("RajeshK", UUID.randomUUID().toString(), "Rajesh", "Kuthrapali", 45, "India");
		User user8 = new User("AlanP", UUID.randomUUID().toString(), "Alan", "Peterson", 41, "USA");
		User user9 = new User("ThiagoA", UUID.randomUUID().toString(), "Thiago", "Alpaca", 18, "New Zealand");
		User user10 = new User("PhilipM", UUID.randomUUID().toString(), "Philip", "Morgan", 49, "Scotland");
		
		List<User> usersList = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10);
		
		usersList = usersList.stream().map(user -> {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			return user;
		}).collect(Collectors.toList());
		
		userRepository.saveAll(usersList);

	}

}
