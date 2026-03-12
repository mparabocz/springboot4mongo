package com.mparabocz.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mparabocz.workshopmongo.domain.User;
import com.mparabocz.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User abraao = new User(null, "Abraao", "abraao@gmail.com");
		User braulio = new User(null, "Braulio", "brauliao@gmail.com");
		User claudia = new User(null, "Claudia", "claudinha@gmail.com");
		userRepository.saveAll(Arrays.asList(abraao, braulio, claudia));
		
	}

}
