package com.sumana.eventmanagement.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sumana.eventmanagement.entities.Event;
import com.sumana.eventmanagement.repositories.EventRepository;
import com.sumana.eventmanagement.service.EventServiceI;

@Service
public class EventService implements EventServiceI {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public ResponseEntity startEvent(Long eventId) {
		Event event = eventRepository.findOne(eventId);
		if (event == null) {
			throw new ResourceNotFoundException();
		}
		event.setStarted(true);
		eventRepository.save(event);
		return ResponseEntity.ok(event.getName() + " has started");
	}

}
