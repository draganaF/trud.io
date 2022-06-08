package com.sbnz.trud.io.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbnz.trud.io.exeption.MissingEntityException;
import com.sbnz.trud.io.model.User;
import com.sbnz.trud.io.repository.UserRepository;
import com.sbnz.trud.io.service.contracts.IUserService;

@Service
public class UserService extends GenericService<User> implements IUserService {

	private UserRepository userRepository;
	
	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmailAddress(email);
	}
	
	@Override
	public User login(String email, String password) {
		User user = findByEmail(email);
		if(user == null) {
			throw new MissingEntityException("User with given email does not exist.");
		}
		
		return user;
	}

}
