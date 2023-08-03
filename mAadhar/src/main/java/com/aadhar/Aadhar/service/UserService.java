package com.aadhar.Aadhar.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aadhar.Aadhar.entity.User;
import com.aadhar.Aadhar.repository.UserRepository;

@Service
public class UserService {
	
	
	@Autowired
	UserRepository ur;

	
	
	
	public List<User> getAllUser(){
		return ur.findAll();
	}
	
	
	public User getById(int id) {
		return ur.findById(id).get();
	}
	
	
	public void insert(User user) {
		ur.save(user);
	}
	
	public String update(int id, User user) {
		Optional<User> userdetails = ur.findById(id);
		if(userdetails.isPresent()) {
			User u = userdetails.get();
			u.setName(user.getName());
			u.setAadharNo(user.getAadharNo());
			u.setDob(user.getDob());
			u.setEmail(user.getEmail());
			u.setGender(user.getGender());
			u.setAddress(user.getAddress());
			u.setIssueDate(user.getIssueDate());
			u.setStatus(user.getStatus());		
			ur.save(u);
			
			return "Updated";
		}else {
			return "Not Updated";
		}
		
		
	}
	
	public User getByaadharNoAndMobile(String aadharNo, String mobile) {
		return ur.findByaadharNoAndMobile(aadharNo,mobile);
	}
	

	
	
	public void delete(int id) {
		ur.deleteById(id);
	}
	
	
}
