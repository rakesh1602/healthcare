package com.crossasyst.docon.controller;

import com.crossasyst.docon.model.UserRegister;
import com.crossasyst.docon.response.UserRegisterResponse;
import com.crossasyst.docon.service.UserRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
public class UserRegisterController {

    private final UserRegisterService userRegisterService;

    @Autowired
    public UserRegisterController(UserRegisterService userRegisterService) {
        this.userRegisterService = userRegisterService;
    }
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<UserRegisterResponse>> addPatient(@RequestBody UserRegister userRegister) {
        Mono<UserRegister> userRegisterMono = Mono.just(userRegister);
        return userRegisterService.addPatient(userRegisterMono)
                .map(userRegisterResponse -> ResponseEntity.ok(userRegisterResponse));
    }



   /* @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<UserRegisterResponse> addPatient(@RequestBody Mono<UserRegister> userRegister){
        return this.userRegisterService.addPatient(userRegister);
    }*/
}
