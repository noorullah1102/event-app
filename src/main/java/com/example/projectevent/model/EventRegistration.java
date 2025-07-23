package com.example.projectevent.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "registrations")
@Data

public class EventRegistration {
    @Id
    private String id;
    private String eventId;
    private Map<String, String> answers; // question → answer

    public EventRegistration(String id, String eventId, Map<String, String> answers) {
        this.id = id;
        this.eventId = eventId;
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }
}