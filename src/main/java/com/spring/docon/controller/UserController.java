package com.spring.docon.controller;

import com.spring.docon.model.Account;
import com.spring.docon.model.UserRegister;
import com.spring.docon.response.UserResponse;
import com.spring.docon.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserRegisterService userRegisterService;

    @Autowired
    public UserController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }

<<<<<<< HEAD
=======


>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
    @PostMapping(path = "/users")
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRegister userRegister) {
        UserResponse userResponse = userRegisterService.addUser(userRegister);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

<<<<<<< HEAD
    @GetMapping(path = "/accounts/{accountId}")
    public ResponseEntity<Account> getAccount(@PathVariable Long accountId){
        Account account=userRegisterService.getAccounts(accountId);
        return new ResponseEntity<>(account, HttpStatus.OK);
=======
    @PostMapping(value = "/accounts/{accountId}/users")
    public ResponseEntity<UserResponse> addUsersByAccountId(@RequestBody UserRegister userRegister, @PathVariable Long accountId )
    {
        UserResponse userResponse = userRegisterService.addUserByAccountId(userRegister, accountId);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11


    @GetMapping(value = "/accounts/{accountId}/users")
    public ResponseEntity<List<UserRegister>> getAllUsersByAccountId(@PathVariable Long accountId){
        List<UserRegister> userRegister = userRegisterService.getAllUsersByAccountId(accountId);
        return new ResponseEntity<>(userRegister , HttpStatus.OK);
    }

    @GetMapping(value = "/users/{userId}")
    public ResponseEntity<UserRegister> getUserById(@PathVariable Long userId)
    {
        UserRegister userRegister = userRegisterService.getUserById(userId);
        return new ResponseEntity<>(userRegister , HttpStatus.OK);
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUser(@PathVariable Long userId)
    {
        userRegisterService.deleteUser(userId);
    }
}
