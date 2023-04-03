package com.crossasyst.docon.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.PipedReader;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {

    private String prefix;

    private String firstName;

    private String lastName;

    private Integer phoneNumber;

    /*private Date dob;*/

    private String gender;

    private String role;

    private Account account;
}
