package com.usercrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.usercrud.entity.User;
import com.usercrud.service.UserService;




@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService service;


	
	@PostMapping(value="/register")
	public ResponseEntity<?> register(@RequestBody User user) {
		//TODO: process POST request
		return ResponseEntity.status(HttpStatus.OK).body(service.register(user));
	}
	
	@PostMapping(value="/login")
	public ResponseEntity<?> login(@RequestParam("email") String email ,@RequestParam("password") String password ) {
		return ResponseEntity.status(HttpStatus.OK).body(service.login(email, password));
	}
	
	@GetMapping(value="/getuser/{userId}")
	public User getUser(@PathVariable("userId") Integer userid) {
		return service.getUserById(userid);
	}
	
	@GetMapping(value="/getalluser")
	public List<User> getMethodName() {
		return service.getAllUser();
	}
	
	@PutMapping(value="updateuser/{id}")
	public ResponseEntity<?>  update(@PathVariable("id") int id, @RequestBody User user) {
		//TODO: process PUT request
		
		 return ResponseEntity.status(HttpStatus.OK).body(service.updateUser(id,user));
	}
	
	@DeleteMapping(value="deleteuser/{id}")
	public ResponseEntity<?>  delete(@PathVariable("id") int id) {
		//TODO: process PUT request
		
		 return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(id));
	}
	
}
