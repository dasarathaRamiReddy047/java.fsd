package com.aadhar.Aadhar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aadhar.Aadhar.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {


}
