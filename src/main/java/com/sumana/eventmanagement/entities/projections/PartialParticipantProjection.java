package com.sumana.eventmanagement.entities.projections;

import org.springframework.data.rest.core.config.Projection;

import com.sumana.eventmanagement.entities.Participant;

@Projection(name="partial", types=Participant.class)
public interface PartialParticipantProjection {
	public abstract String getName();
	public abstract Boolean getCheckedIn();
}
