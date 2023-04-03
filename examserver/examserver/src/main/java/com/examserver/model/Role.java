package com.examserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    @NotBlank(message = "Role Name cannot be blank.")
    private String roleName;
}
