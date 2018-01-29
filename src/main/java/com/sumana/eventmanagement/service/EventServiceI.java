package com.sumana.eventmanagement.service;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;

import com.sumana.eventmanagement.entities.Event;

public interface EventServiceI {
	public abstract ResponseEntity startEvent(Long eventId) throws ResourceNotFoundException;
}
