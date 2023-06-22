package com.crossasyst.sqstodatabase.controller;

import com.crossasyst.sqstodatabase.model.Message;
import com.crossasyst.sqstodatabase.service.CsvDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/v1")
@CrossOrigin(value = "*")
public class MessageController {

    private final CsvDataService csvDataService;

    @Autowired
    public MessageController(CsvDataService csvDataService) {
        this.csvDataService = csvDataService;
    }

    @PostMapping("/messages")
    public ResponseEntity<String> processSQSMessages() {
        csvDataService.processCsvDataFromSqs();
        return new ResponseEntity<>("SQS messages processed successfully", HttpStatus.OK);
    }

    @PostMapping(value = "/receive-message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> receiveMessages(@RequestBody Message message){
        csvDataService.processMessage(message);
        return ResponseEntity.ok("Message Received");
    }
}

