package com.mparabocz.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mparabocz.workshopmongo.domain.Post;
import com.mparabocz.workshopmongo.repository.PostRepository;
import com.mparabocz.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found."));
	}

	public List<Post> findByTitle(String text) {
		return repository.findByTitleContainingIgnoreCase(text);
	}

}
