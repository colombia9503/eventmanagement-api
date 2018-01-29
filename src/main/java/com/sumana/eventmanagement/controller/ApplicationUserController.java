package com.sumana.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumana.eventmanagement.entities.ApplicationUser;
import com.sumana.eventmanagement.service.ApplicationUserServiceI;

@RepositoryRestController
@RequestMapping("/users")
public class ApplicationUserController {
	
	@Autowired
	private ApplicationUserServiceI applicationUserService;
	
	@PostMapping("/sign-up") 
	public void signUp(@RequestBody ApplicationUser user) {
		applicationUserService.createUser(user);
	}
}
