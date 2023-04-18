package com.spring.docon.controller;

import com.spring.docon.model.Patient;
import com.spring.docon.response.PatientResponse;
import com.spring.docon.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(path = "patients/{patientId}")
    public ResponseEntity<Patient> searchPatient(@PathVariable Long patientId) {
        Patient patient = patientService.searchPatient(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    @GetMapping(path = "/patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @PutMapping("patients/{patientId}")
    public ResponseEntity<Patient>updatePatient(@PathVariable Long patientId,@RequestBody Patient patient){
        Patient patient1 = patientService.updatePatient(patientId,patient);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @DeleteMapping(path = "patients/{patientId}")
    public void deleteById(@PathVariable Long patientId){
        patientService.deleteById(patientId);
    }


}
