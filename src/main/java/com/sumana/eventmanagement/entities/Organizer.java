package com.sumana.eventmanagement.entities;

import java.util.Objects;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({ "resourceId" })
@Entity
public class Organizer extends AbstractEntity {
	private String name;

	@OneToMany(mappedBy = "organizer")
	private Set<Event> event;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Event> getEvent() {
		return event;
	}

	public void setEvent(Set<Event> event) {
		this.event = event;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return Objects.equals(id, ((Organizer) obj).id);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(id);
	}

	public Long getResourceId() {
		return id;
	}
}
