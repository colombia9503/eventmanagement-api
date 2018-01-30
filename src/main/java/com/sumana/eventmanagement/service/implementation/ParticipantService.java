package com.sumana.eventmanagement.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.sumana.eventmanagement.common.exceptions.AlreadyCheckedInException;
import com.sumana.eventmanagement.common.exceptions.NotCheckedInException;
import com.sumana.eventmanagement.entities.Participant;
import com.sumana.eventmanagement.repositories.ParticipantRepository;
import com.sumana.eventmanagement.service.ParticipantServiceI;

@Service
public class ParticipantService implements ParticipantServiceI {
	@Autowired
	private ParticipantRepository participantRepository;

	@Override
	public Participant checkInParticipant(Long id) {
		
		Participant participant = participantRepository.findOne(id);
		if (participant != null) {
			if (participant.getCheckedIn()) {
				throw new AlreadyCheckedInException();
			}
			participant.setCheckedIn(true);
			participantRepository.save(participant);
		} else {
			throw new ResourceNotFoundException();
		}
		return participant;
	}

	@Override
	public Participant checkOutParticipant(Long id) {
		
		Participant participant = participantRepository.findOne(id);
		if (participant != null) {
			if (!participant.getCheckedIn()) {
				throw new NotCheckedInException();
			}
			participant.setCheckedIn(false);
			participantRepository.save(participant);
		} else {
			throw new ResourceNotFoundException();
		}
		return participant;
	}

}
