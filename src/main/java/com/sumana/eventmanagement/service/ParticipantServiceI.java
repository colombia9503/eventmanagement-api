package com.sumana.eventmanagement.service;

import org.springframework.http.ResponseEntity;

import com.sumana.eventmanagement.entities.Participant;

public interface ParticipantServiceI {
	public abstract Participant checkInParticipant(Long id);
	public abstract Participant checkOutParticipant(Long id);
}
