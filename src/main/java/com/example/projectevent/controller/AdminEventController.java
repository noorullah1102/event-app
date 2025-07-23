package com.example.projectevent.controller;

import com.example.projectevent.model.Event;
import com.example.projectevent.model.EventField;
import com.example.projectevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/events")
public class AdminEventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("event", new Event());
        model.addAttribute("fields", new ArrayList<EventField>());
        return "event-create";
    }

    @PostMapping("/create")
    public String createEvent(@ModelAttribute Event event,
                              @RequestParam("fieldLabel") List<String> fieldLabels,
                              @RequestParam("fieldType") List<String> fieldTypes,
                              @RequestParam(value = "fieldOptions", required = false) List<String> fieldOptions) {

        List<EventField> dynamicFields = new ArrayList<>();
        for (int i = 0; i < fieldLabels.size(); i++) {
            EventField field = new EventField(fieldLabels.get(i), fieldTypes.get(i));

            if ("options".equals(fieldTypes.get(i)) && fieldOptions != null && fieldOptions.size() > i) {
                List<String> optionsList = List.of(fieldOptions.get(i).split("\\s*,\\s*"));
                field.setOptions(optionsList);
            }

            dynamicFields.add(field);
        }

        event.setFields(dynamicFields);
        eventRepository.save(event);
        return "redirect:/admin/dashboard";
    }

}