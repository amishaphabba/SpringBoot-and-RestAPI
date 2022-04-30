package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Users;
import com.example.demo.services.UsersService;

@RestController
public class UsersController {
	@Autowired
	UsersService us;
	
    @GetMapping("/users")
	public String getUsers(){
		return us.getUsers();
	}
	
	@GetMapping("/users/{user_id}")
	public String getUserOnId(@PathVariable int user_id) {
		return us.getUserOnId(user_id);	
	}
	
	@PostMapping("/users")
	public String addUser(@RequestBody Users user) {
		return us.addUser(user);		
	}
	@PutMapping("/users/{user_id}")
	public String updatUser(@RequestBody Users user,@PathVariable int user_id) {
		return us.updateUser(user,user_id);
		
	}
	
	@DeleteMapping("/users/{user_id}")
	public String deleteUser(@PathVariable int user_id ){
		return us.deleteUser(user_id);
	}

}
