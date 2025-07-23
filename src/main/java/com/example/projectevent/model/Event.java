package com.example.projectevent.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "events")
@Data
@NoArgsConstructor
public class Event {
    @Id
    private String id;
    private String title;
    private String description;
    private double price;
    private List<EventField> fields;  // dynamic fields/questions

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Event(String description, String id, String title, double price, List<EventField> fields) {
        this.description = description;
        this.id = id;
        this.title = title;
        this.price = price;
        this.fields = fields;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EventField> getFields() {
        return fields;
    }

    public void setFields(List<EventField> fields) {
        this.fields = fields;
    }
}