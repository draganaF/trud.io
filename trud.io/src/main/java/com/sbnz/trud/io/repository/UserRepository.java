package com.sbnz.trud.io.repository;

import org.springframework.stereotype.Repository;

import com.sbnz.trud.io.model.User;
import com.sbnz.trud.io.repository.generic.GenericRepository;

@Repository
public interface UserRepository extends GenericRepository<User>{
	User findByEmailAddress(String email);
}
