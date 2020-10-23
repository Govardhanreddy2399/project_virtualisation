package com.example.demo.controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.object.Person;
import com.example.demo.service.FirebaseService;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
	
	@Autowired
	FirebaseService fireBaseService;
	
	
	@GetMapping("/getuserdetails")
	public Person getUserDetails(@RequestHeader String name) throws InterruptedException, ExecutionException {
		return fireBaseService.getUserDetails(name);
	}
	
	
	
	@PostMapping("/createuser")
	public String createUserDetails(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return fireBaseService.saveUserDetails(person);
	}
	
	@PutMapping("/updateuser")
	public String updateUserDetails(@RequestBody Person person) throws InterruptedException, ExecutionException {
		return fireBaseService.updateUserDetails(person);
	}
	
	
	@DeleteMapping("/deleteuser")
	public String deleteUserDetails(@RequestHeader String name) {
		return fireBaseService.deleteUser(name);
	}




}
