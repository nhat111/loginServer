package com.javacode.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javacode.model.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

	Optional<Login> findByUserName(String username);

	boolean existsByUserName(String userName);

	Login findUserByUserName(String userName);

}
