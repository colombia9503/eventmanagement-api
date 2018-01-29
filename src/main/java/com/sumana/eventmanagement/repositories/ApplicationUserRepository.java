package com.sumana.eventmanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumana.eventmanagement.entities.ApplicationUser;

public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
	public abstract ApplicationUser findByUsername(String username);
}
