package com.spring.docon.controller;

import com.spring.docon.model.Account;
import com.spring.docon.model.UserRegister;
import com.spring.docon.response.UserResponse;
import com.spring.docon.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRegisterService userRegisterService;

    @Autowired
    public UserController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

    @PostMapping(path = "/person")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRegister userRegister) {
        UserResponse userResponse = userRegisterService.addUser(userRegister);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping(path = "/account/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId){
        Account account=userRegisterService.getAccounts(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);

    }
}
