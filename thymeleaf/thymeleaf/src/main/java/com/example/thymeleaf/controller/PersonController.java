package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.Person;
import com.example.thymeleaf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public String index(Model model){
        return personService.index(model);
    }
}
