package com.example.oneToOneMapping.controller;

import com.example.oneToOneMapping.model.Person;
import com.example.oneToOneMapping.response.PersonResponse;
import com.example.oneToOneMapping.service.PersonAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {
    @Autowired
    private final PersonAddressService personAddressService;

    public PersonController(PersonAddressService personAddressService) {
        this.personAddressService = personAddressService;
    }

    @PostMapping(path = "/persons", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonResponse> createPerson(@RequestBody Person person){
        PersonResponse personResponse= personAddressService.createPerson(person);
        return new ResponseEntity<>(personResponse, HttpStatus.CREATED);
    }

    @GetMapping(path = "/persons/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> getPerson(@PathVariable Long id, @RequestBody Person person){
        person= personAddressService.getPerson(id);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping(path = "/persons/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        personAddressService.deletePerson(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(path="/persons/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updatePerson(@PathVariable Long id,@RequestBody Person person){
        personAddressService.updatePerson(id,person);
        return ResponseEntity.ok().build();
    }
}
