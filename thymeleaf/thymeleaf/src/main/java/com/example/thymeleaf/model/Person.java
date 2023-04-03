package com.example.thymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private int age;

}
