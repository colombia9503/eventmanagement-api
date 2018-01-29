package com.sumana.eventmanagement.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.sumana.eventmanagement.entities.Participant;

public interface ParticipantRepository extends PagingAndSortingRepository<Participant, Long> {

}
