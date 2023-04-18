package com.spring.docon.controller;

<<<<<<< HEAD
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
=======


import com.spring.docon.model.Account;
import com.spring.docon.response.AccountResponse;
import com.spring.docon.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
public class AccountController {


    private final AccountService accountService;

>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

<<<<<<< HEAD
    @PatchMapping(value = "/password/{enrollmentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PasswordResponse> createPassword(@PathVariable UUID enrollmentId, @RequestBody Password password, String emailId, Date dob) {
        PasswordResponse passwordResponse = accountService.createPassword(enrollmentId, password, emailId, dob);
        return new ResponseEntity<>(passwordResponse, HttpStatus.OK);
    }
}
=======
    @PostMapping(value = "/accounts")
    public ResponseEntity<AccountResponse> addAccount(@RequestBody Account account)
    {
        AccountResponse accountResponse = accountService.addAccount(account);
        return new ResponseEntity<>(accountResponse, HttpStatus.OK);
    }

}

>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
