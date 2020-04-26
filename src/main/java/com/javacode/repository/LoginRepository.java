package com.javacode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer>{
	
	Login findUserByUserName(String userName);
	
	Boolean existsByUserName(String userName);
	
	Optional<Login> findByUserName(String userName);
	

}
