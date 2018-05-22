package com.dxc.darklightrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dxc.darklightrest.entity.User;

public interface UserRepository extends JpaRepository<User, String>{
	
	
}
