package com.spring.docon.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Data
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegister {

    @NotBlank(message = "Prefix should not be empty or null")
    private String prefix;

    @NotBlank(message = "First name should not be empty or null.")
    private String firstName;

    @NotBlank(message = "Last name should not be empty or null.")
    private String lastName;

    @NotBlank(message = "Phone number should not be empty or null.")
    private String phoneNumber;

    @NotBlank(message = "Date of birth should not be empty or null.")
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    private Date dob;

    @NotBlank(message = "Gender should not be empty or null.")
    private String gender;

    @NotBlank(message = "Role should not be empty or null.")
    private String role;

    private Account account =new Account();
}