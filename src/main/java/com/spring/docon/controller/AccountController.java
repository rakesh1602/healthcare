package com.spring.docon.controller;

import com.spring.docon.model.patch.Password;
import com.spring.docon.response.PasswordResponse;
import com.spring.docon.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.UUID;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PatchMapping(value = "/password/{enrollmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PasswordResponse> createPassword(@PathVariable UUID enrollmentId, @RequestBody Password password, String emailId, Date dob) {
        PasswordResponse passwordResponse = accountService.createPassword(enrollmentId, password, emailId, dob);
        return new ResponseEntity<>(passwordResponse, HttpStatus.OK);
    }
}
