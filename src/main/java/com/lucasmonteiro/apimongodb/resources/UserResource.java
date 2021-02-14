package com.lucasmonteiro.apimongodb.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucasmonteiro.apimongodb.domain.User;
import com.lucasmonteiro.apimongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	// @RequestMapping(method = RequestMethod.GET) --> Também é possível fazer desta forma
	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		List<User> users = service.findAll();
		return ResponseEntity.ok().body(users);
	}

}
