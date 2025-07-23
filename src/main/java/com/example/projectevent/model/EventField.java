package com.example.projectevent.model;

import lombok.*;

import java.util.List;


public class EventField {
    private String label;   // e.g., "Full Name"
    private String type;
    // e.g., "text", "email", "textarea", etc.
    private List<String> options;

    public EventField() {}

    public EventField(String label, String type) {
        this.label = label;
        this.type = type;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }
}


