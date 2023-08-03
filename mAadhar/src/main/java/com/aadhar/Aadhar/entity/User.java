package com.aadhar.Aadhar.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String aadharNo;
	private String dob;
	private String email;
	private String mobile;
	private String gender;
	private String address;
	private String status;
	private String issueDate;
	



	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(String aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public int getId() {
		return id;
	}
	public User(String name, String aadharNo, String dob, String email, String mobile, String gender, String address,
			String status, String issueDate) {
		super();
		this.name = name;
		this.aadharNo = aadharNo;
		this.dob = dob;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.address = address;
		this.status = status;
		this.issueDate = issueDate;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", aadharNo=" + aadharNo + ", dob=" + dob + ", email=" + email
				+ ", mobile=" + mobile + ", gender=" + gender + ", address=" + address + ", status=" + status
				+ ", issueDate=" + issueDate + "]";
	}
	
	public User() {
		
	}
	
	
	
	
}
