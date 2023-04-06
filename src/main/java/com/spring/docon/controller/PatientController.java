package com.spring.docon.controller;

import com.spring.docon.model.Patient;
import com.spring.docon.response.PatientResponse;
import com.spring.docon.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(originPatterns = "*")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }


    @PostMapping(path = "/patients")
    public ResponseEntity<PatientResponse> addPatient(@RequestBody Patient patient){
        PatientResponse patientResponse=patientService.addPatient(patient);
        return new ResponseEntity<>(patientResponse, HttpStatus.OK);
    }
}
