package com.sbnz.trud.io.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sbnz.trud.io.apiContracts.request.LoginUser;
import com.sbnz.trud.io.service.contracts.IUserService;

@CrossOrigin
@RestController
@RequestMapping(value="/api/v1/auth")
public class AuthController {
	private IUserService userService;
	
	@Autowired
	public AuthController(IUserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("login")
	public ResponseEntity<?> loginUser(@RequestBody LoginUser user){
		return new ResponseEntity<>(userService.login(user.getEmail(), user.getPassword()), HttpStatus.OK);
	}
}
