package com.example.eventmanagementsystem.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import com.example.eventmanagementsystem.model.*;
import com.example.eventmanagementsystem.service.*;

@RestController
public class SponsorController {

    @Autowired
    public SponsorJpaService service;

    @GetMapping("/events/sponsors")
    public ArrayList<Sponsor> getSponsors() {
        return service.getSponsors();
    }

    @GetMapping("/events/sponsors/{sponsorId}")
    public Sponsor getSponsorById(@PathVariable("sponsorId") int sponsorId) {
        return service.getSponsorById(sponsorId);
    }

    @PostMapping("/events/sponsors")
    public Sponsor addSponsor(@RequestBody Sponsor sponsor) {
        return service.addSponsor(sponsor);
    }

    @PutMapping("/events/sponsors/{sponsorId}")
    public Sponsor updateSponsor(@PathVariable("sponsorId") int sponsorId, @RequestBody Sponsor sponsor) {
        return service.updateSponsor(sponsorId, sponsor);
    }

    @DeleteMapping("/events/sponsors/{sponsorId}")
    public void deleteSponsor(@PathVariable("sponsorId") int sponsorId) {
        service.deleteSponsor(sponsorId);
    }

    @GetMapping("/sponsors/{sponsorId}/events")
    public List<Event> getSponsorEvents(int sponsorId) {
        return service.getSponsorEvents(sponsorId);
    }

}
