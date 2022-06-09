package com.sbnz.trud.io.service.contracts;

import com.sbnz.trud.io.model.User;

public interface IUserService extends IGenericService<User> {
	User findByEmail(String email);
	
	User login(String email, String password);
}
