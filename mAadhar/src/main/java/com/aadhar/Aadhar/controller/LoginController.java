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

import com.aadhar.Aadhar.entity.Login;
import com.aadhar.Aadhar.service.LoginService;



@RestController
@CrossOrigin
public class LoginController {
	
	@Autowired 
	LoginService ls;
	
	@GetMapping("login")
	public List<Login> getAllLogin(){
		return  ls.getAllLogin();
	}
	
	
	@GetMapping("login/{id}")
	public Login getBtId(@PathVariable int id) {
		return ls.getByIdLogin(id);
	}
	
	
	@PostMapping("login")
	public void insert(@RequestBody Login login) {
		ls.insertLogin(login);
	}
	
	@PutMapping("login/{id}")
	public void update(@PathVariable int id,@RequestBody Login login) {
		ls.updateLogin(id, login);
	}
	
	@DeleteMapping("login/{id}")
	public void delete(@PathVariable int id) {
		ls.deleteLogin(id);
	}
	
	
	
	
}
