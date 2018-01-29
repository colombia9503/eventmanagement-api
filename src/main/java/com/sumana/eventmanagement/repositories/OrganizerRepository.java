package com.sumana.eventmanagement.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sumana.eventmanagement.entities.Organizer;

public interface OrganizerRepository extends PagingAndSortingRepository<Organizer, Long> {

}
