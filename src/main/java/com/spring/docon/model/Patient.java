package com.spring.docon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Patient {

    @JsonIgnore
    private String bloodGroup;

    @JsonIgnore
    private String height;

    @JsonIgnore
    private String weight;

    private UserRegister user;
}
