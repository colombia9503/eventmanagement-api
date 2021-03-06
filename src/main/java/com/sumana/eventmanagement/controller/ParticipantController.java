package com.sumana.eventmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.PersistentEntityResource;
import org.springframework.data.rest.webmvc.PersistentEntityResourceAssembler;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sumana.eventmanagement.annotations.RequestInterceptor;
import com.sumana.eventmanagement.entities.Participant;
import com.sumana.eventmanagement.service.ParticipantServiceI;

@RepositoryRestController
@RequestMapping("/participants")
public class ParticipantController {
	@Autowired
	private ParticipantServiceI participantService;

	@RequestInterceptor
	@PostMapping("/checkin/{id}")
	public ResponseEntity<PersistentEntityResource> checkIn(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) throws RuntimeException {
		Participant participant;
		try {
			participant = participantService.checkInParticipant(id);
		} catch (Exception e) {
			throw e;
		}
		
		return ResponseEntity.ok(assembler.toResource(participant));
	}
	
	@RequestInterceptor
	@PostMapping("/checkout/{id}")
	public ResponseEntity<PersistentEntityResource> checkOut(@PathVariable Long id,
			PersistentEntityResourceAssembler assembler) {
		Participant participant = participantService.checkOutParticipant(id);
		return ResponseEntity.ok(assembler.toResource(participant));
	}
}
