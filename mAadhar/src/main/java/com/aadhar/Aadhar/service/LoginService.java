package com.aadhar.Aadhar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadhar.Aadhar.entity.Login;
import com.aadhar.Aadhar.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository lr;
	
	public List<Login> getAllLogin(){
		return lr.findAll();
	}
	
	public Login getByIdLogin(int id) {
		return lr.findById(id).get();
	}
	
	
	public void insertLogin(Login login) {
		lr.save(login);
	}
	
	public void updateLogin(int id, Login login) {
		Optional<Login> LoginDetails = lr.findById(id);
		
		if(LoginDetails.isPresent()) {
			Login l = LoginDetails.get();
			l.setName(login.getName());
			l.setEmail(login.getEmail());
			l.setPassword(login.getPassword());
			l.setPhone(login.getPhone());
			lr.save(l);
		}
		
		
	}
	
	
	public void deleteLogin(int id) {
	 lr.deleteById(id);
	}
	
}
