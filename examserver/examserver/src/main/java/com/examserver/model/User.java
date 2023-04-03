package com.examserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Validated
public class User {

    @NotBlank(message = "User name cannot be blank.")
    @Size(max = 20, message = "Maximum 20 character allowed.")
    private String userName;

    @NotBlank(message = "first name cannot be blank.")
    private String firstName;

    @NotBlank(message = "last name cannot be blank.")
    private String lastName;

    @NotBlank(message = "Email name cannot be blank.")
    private String email;

    private String phone;

    private boolean isEnabled = true;

    private String Profile;

    private List<Role> roleList;
}
