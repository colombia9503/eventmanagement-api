package com.sumana.eventmanagement.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sumana.eventmanagement.entities.Venue;

public interface VenueRepository extends PagingAndSortingRepository<Venue, Long> {

}
