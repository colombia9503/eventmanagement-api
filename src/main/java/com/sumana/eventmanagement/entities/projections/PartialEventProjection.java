package com.sumana.eventmanagement.entities.projections;

import java.time.Instant;
import java.time.ZonedDateTime;

import org.springframework.data.rest.core.config.Projection;

import com.sumana.eventmanagement.entities.Event;


@Projection(name="partial", types = {Event.class})
public interface PartialEventProjection {
	public abstract String getName();
	public abstract ZonedDateTime getStartTime();
	public abstract ZonedDateTime getEndTime();
	public abstract Instant getCreated();
}

