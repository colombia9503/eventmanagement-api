package com.sumana.eventmanagement.entities.projections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import com.sumana.eventmanagement.entities.Venue;

@Projection(name="virtual", types = { Venue.class })
public interface StreetAddressProjection {
	@Value("#{target.streetAddress} #{target.streetAddress2}")
	public abstract String getCompleteStreetAddress();
}
