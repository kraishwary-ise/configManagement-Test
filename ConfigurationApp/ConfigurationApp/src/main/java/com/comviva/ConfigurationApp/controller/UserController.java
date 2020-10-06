package com.comviva.ConfigurationApp.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comviva.ConfigurationApp.model.User;
import com.comviva.ConfigurationApp.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
@Autowired
private UserService userService;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/LoginUsers")
	public User loginUser(@RequestBody User user) throws Exception 	{
		
		String tempEmailId = user.getUserEmail();
		System.out.println(tempEmailId);
		String tempPassword = user.getPassword();
		User userObj = null;
		if(tempEmailId!=null&&tempPassword!=null) {
			userObj = userService.fetchUserByEmailAndPassword(tempEmailId,tempPassword);
			
		}
		
		if(userObj==null) {
			throw new Exception("Bad credentials");
		}
		
		return userObj;
	}

}
