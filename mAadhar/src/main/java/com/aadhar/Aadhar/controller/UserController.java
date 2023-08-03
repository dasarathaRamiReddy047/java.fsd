package com.aadhar.Aadhar.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aadhar.Aadhar.entity.User;
import com.aadhar.Aadhar.service.UserService;

import jakarta.websocket.server.PathParam;

@RestController
@CrossOrigin
public class UserController {
	@Autowired 
	UserService us;
	
	@GetMapping("user")
	public List<User> getAllLogin(){
		return  us.getAllUser();
	}
	
	
	@GetMapping("user/{id}")
	public User getBtId(@PathVariable int id) {
		return us.getById(id);
	}
	
	@GetMapping("user/{aadharNo}/{mobile}")
	public User getByAadharNoAndMobile(@PathVariable String aadharNo, @PathVariable String mobile) {
		return us.getByaadharNoAndMobile(aadharNo, mobile);
	}
	
	
	@PostMapping("user")
	public void insert(@RequestBody User user) {
		us.insert(user);
	}
	
	@PutMapping("user/{id}")
	public void update(@PathVariable int id,@RequestBody User user) {
		us.update(id, user);
		System.out.println(id+" " + user);
	}
	
	@DeleteMapping("user/{id}")
	public void delete(@PathVariable int id) {
		us.delete(id);
	}
	
	
}
