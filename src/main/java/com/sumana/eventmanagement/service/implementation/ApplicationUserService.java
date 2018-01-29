package com.sumana.eventmanagement.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sumana.eventmanagement.entities.ApplicationUser;
import com.sumana.eventmanagement.repositories.ApplicationUserRepository;
import com.sumana.eventmanagement.service.ApplicationUserServiceI;

@Service
public class ApplicationUserService implements ApplicationUserServiceI {
	
	@Autowired
	private ApplicationUserRepository applicationUserRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void createUser(ApplicationUser user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		applicationUserRepository.save(user);
	}

}
