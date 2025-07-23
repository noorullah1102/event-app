package com.example.projectevent.controller;

import com.example.projectevent.model.Event;
import com.example.projectevent.model.EventRegistration;
import com.example.projectevent.repository.EventRegistrationRepository;
import com.example.projectevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/user/events")
public class UserEventController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventRegistrationRepository registrationRepository;

    // Show all events
    @GetMapping
    public String showAllEvents(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "event-list";
    }
    @GetMapping("/history")
    public String showhisotry(Model model) {
        List<Event> events = eventRepository.findAll();
        model.addAttribute("events", events);
        return "history";
    }

    // Show registration form for a specific event
    @GetMapping("/{eventId}/register")
    public String showRegistrationForm(@PathVariable String eventId, Model model) {
        Event event = eventRepository.findById(eventId).orElseThrow();
        model.addAttribute("event", event);
        return "event-register";
    }

    // Handle registration
    @PostMapping("/{eventId}/register")
    public String handleRegistration(@PathVariable String eventId,
                                     @RequestParam Map<String, String> formData) {

        // Remove built-in params like _csrf
        formData.remove("_csrf");

        EventRegistration registration = new EventRegistration(null, eventId, formData);
        registrationRepository.save(registration);

        return "redirect:/user/dashboard";
    }
}