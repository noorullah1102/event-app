package com.example.projectevent.repository;


import com.example.projectevent.model.EventRegistration;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventRegistrationRepository extends MongoRepository<EventRegistration, String> {
}
