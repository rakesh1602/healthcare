package com.spring.docon.controller;

import com.spring.docon.entity.PrefixEntity;
import com.spring.docon.service.PrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(originPatterns = "*")
public class PrefixController {

    private final PrefixService prefixService;

    @Autowired
    public PrefixController(PrefixService prefixService){
        this.prefixService=prefixService;
    }

<<<<<<< HEAD
=======


>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
    @GetMapping(path = "/prefixs")
    public ResponseEntity<List<PrefixEntity>> Gender(){
        List<PrefixEntity> prefix=prefixService.getPrefix();
        return new ResponseEntity<>(prefix, HttpStatus.OK);
    }
}
