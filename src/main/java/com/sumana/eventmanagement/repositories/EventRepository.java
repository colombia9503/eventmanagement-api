package com.sumana.eventmanagement.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.sumana.eventmanagement.entities.Event;
import com.sumana.eventmanagement.entities.projections.PartialEventProjection;

import java.lang.String;
import java.time.ZoneId;
import java.util.List;

//annotation to apply the projections into de the rest repository 
//-> doesn't apply to the item resources
@RepositoryRestResource(excerptProjection=PartialEventProjection.class)
public interface EventRepository extends PagingAndSortingRepository<Event, Long> {
	//--path--/search/findByName?name=Spring Data Rest Training 3
	//List<Event> findByName(@Param("name") String name);
	//return a page result
	Page<Event> findByName(@Param("name") String name, Pageable pageable);
	Page<Event> findByNameAndZoneId(@Param("name") String name, @Param("zoneId") ZoneId zoneId, Pageable pageable);
	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	void delete(Long id);
}
