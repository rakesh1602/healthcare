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
    @GetMapping(path = "/prefix")
=======
    @GetMapping(path = "/prefixs")
>>>>>>> c73a568 (password-encrypt)
    public ResponseEntity<List<PrefixEntity>> Gender(){
        List<PrefixEntity> prefix=prefixService.getPrefix();
        return new ResponseEntity<>(prefix, HttpStatus.OK);
    }
}
