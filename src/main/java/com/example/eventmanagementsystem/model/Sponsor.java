package com.example.eventmanagementsystem.model;

import java.util.List;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.*;

@Entity
@Table(name = "sponsor")
public class Sponsor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int sponsorId;

	@Column(name = "name")
	private String sponsorName;

	@Column(name = "industry")
	private String industry;

	@ManyToMany
	@JoinTable(name = "event_sponsor", joinColumns = @JoinColumn(name = "sponsorId"), inverseJoinColumns = @JoinColumn(name = "eventId"))
	@JsonIgnoreProperties("sponsors")
	private List<Event> events;

	public Sponsor() {
	}

	public Sponsor(int sponsorId, String sponsorName, String industry, List<Event> events) {
		this.sponsorId = sponsorId;
		this.sponsorName = sponsorName;
		this.industry = industry;
		this.events = events;
	}

	public int getSponsorId() {
		return sponsorId;
	}

	public void setSponsorId(int sponsorId) {
		this.sponsorId = sponsorId;
	}

	public String getSponsorName() {
		return sponsorName;
	}

	public void setSponsorName(String sponsorName) {
		this.sponsorName = sponsorName;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}