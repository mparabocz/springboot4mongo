package com.mparabocz.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mparabocz.workshopmongo.domain.Post;
import com.mparabocz.workshopmongo.domain.User;
import com.mparabocz.workshopmongo.dto.AuthorDTO;
import com.mparabocz.workshopmongo.repository.PostRepository;
import com.mparabocz.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();
		postRepository.deleteAll();

		User abraao = new User(null, "Abraao", "abraao@gmail.com");
		User braulio = new User(null, "Braulio", "brauliao@gmail.com");
		User claudia = new User(null, "Claudia", "claudinha@gmail.com");
		userRepository.saveAll(Arrays.asList(abraao, braulio, claudia));

		Post p1 = new Post(null, LocalDate.of(2026, 1, 1), "Exciting!",
				"I'm going out to investigate some rumors around my city. Wish me luck.", new AuthorDTO(abraao));
		Post p2 = new Post(null, LocalDate.of(2025, 11, 30), "Beware.",
				"Beware of the old man in a profession where people die young.", new AuthorDTO(abraao));
		Post p3 = new Post(null, LocalDate.of(2024, 9, 9), "Missing you", "You said you'd grow old with me.",
				new AuthorDTO(braulio));
		Post p4 = new Post(null, LocalDate.of(2026, 2, 10), "Right Light",
				"Light leaves right time; right light leaves time right, while time leaves light right where right time leaves light.",
				new AuthorDTO(claudia));
		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		abraao.getPosts().add(p1);
		abraao.getPosts().add(p2);
		braulio.getPosts().add(p3);
		claudia.getPosts().add(p4);
		userRepository.saveAll(Arrays.asList(abraao, braulio, claudia));
	}

}
