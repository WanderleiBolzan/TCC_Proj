package com.uspEsalq.mba.ahp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uspEsalq.mba.ahp.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	
}
