package com.mparabocz.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mparabocz.workshopmongo.domain.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<User>> findAll() {
		User abraao = new User("1", "Abraao", "abraao@gmail.com");
		User braulio = new User("2", "Braulio", "braulio@gmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(abraao, braulio));
		return ResponseEntity.ok().body(list);
	}
}
