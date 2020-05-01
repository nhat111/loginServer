package com.javacode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.model.Register;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Long> {
	
	Register findByUserName(String userName);
	
}
