package com.sumana.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumana.eventmanagement.entities.Event;
import com.sumana.eventmanagement.repositories.EventRepository;
import com.sumana.eventmanagement.service.EventServiceI;

@RepositoryRestController
@RequestMapping("/events")
public class EventKickOffController {

	@Autowired
	private EventServiceI eventService;

	@PostMapping("/start/{id}")
	public ResponseEntity start(@PathVariable Long id) {
		return eventService.startEvent(id);
	}
}
