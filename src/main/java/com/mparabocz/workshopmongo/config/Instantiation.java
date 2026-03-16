package com.mparabocz.workshopmongo.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.mparabocz.workshopmongo.domain.Post;
import com.mparabocz.workshopmongo.domain.User;
import com.mparabocz.workshopmongo.dto.AuthorDTO;
import com.mparabocz.workshopmongo.dto.CommentDTO;
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

		CommentDTO c1 = new CommentDTO("Watch out!", LocalDate.of(2026, 1, 2), new AuthorDTO(braulio));
		CommentDTO c2 = new CommentDTO("Thats sick! GL", LocalDate.of(2026, 1, 4), new AuthorDTO(claudia));
		CommentDTO c3 = new CommentDTO("...Interesting thought.", LocalDate.of(2025, 12, 1), new AuthorDTO(braulio));
		CommentDTO c4 = new CommentDTO("Miss you too buddy haha", LocalDate.of(2024, 9, 11), new AuthorDTO(abraao));
		CommentDTO c5 = new CommentDTO("I'm unsure if that's right or not tho.", LocalDate.of(2026, 2, 10),
				new AuthorDTO(abraao));
		CommentDTO c6 = new CommentDTO("I leave for one day and you hit us with this light? thats not right.",
				LocalDate.of(2026, 2, 11), new AuthorDTO(abraao));

		p1.getComments().addAll(Arrays.asList(c1, c2));
		p2.getComments().addAll(Arrays.asList(c3));
		p3.getComments().addAll(Arrays.asList(c4));
		p4.getComments().addAll(Arrays.asList(c5, c6));

		postRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		abraao.getPosts().add(p1);
		abraao.getPosts().add(p2);
		braulio.getPosts().add(p3);
		claudia.getPosts().add(p4);
		userRepository.saveAll(Arrays.asList(abraao, braulio, claudia));

	}

}
