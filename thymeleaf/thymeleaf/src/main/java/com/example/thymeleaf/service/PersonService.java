package com.example.thymeleaf.service;

import com.example.thymeleaf.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Collection;
import java.util.Map;

@Service
public class PersonService {

    public String index(Model model) {

        model.addAttribute("someone", "This is from service");

        return "index";
        };

    }


