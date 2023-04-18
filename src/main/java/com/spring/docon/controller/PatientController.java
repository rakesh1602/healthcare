package com.spring.docon.controller;

import com.spring.docon.entity.PatientEntity;
import com.spring.docon.model.Patient;
import com.spring.docon.response.PatientResponse;
import com.spring.docon.service.PatientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;

import java.util.List;
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11

@Tag(name = "Create Patient", description = "Create Patient")
//@RequestMapping(path = "v1")
@RestController
@CrossOrigin(originPatterns = "*")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService){
        this.patientService=patientService;
    }

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @PostMapping(path = "/patients", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PatientResponse> addPatient(@RequestBody Patient patient){
        PatientResponse patientResponse=patientService.addPatient(patient);
        return new ResponseEntity<>(patientResponse, HttpStatus.OK);
    }
<<<<<<< HEAD

    @ApiResponse(responseCode = "200", description = "Success")
    @ApiResponse(responseCode = "400", description = "Invalid request")
    @ApiResponse(responseCode = "404", description = "Not found")
    @ApiResponse(responseCode = "500", description = "System error")
    @GetMapping(path = "/patients/{patientId}")
    public ResponseEntity<Patient> getPatient(@PathVariable Long patientId){
        Patient patient=patientService.getPatient(patientId);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
=======
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

    @DeleteMapping(path = "patients/{patientId}")
    public void deleteById(@PathVariable Long patientId){
        patientService.deleteById(patientId);
    }

    @PutMapping(value = "/patients/{patientId}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long patientId , @RequestBody Patient patient)
    {
        Patient patient1= patientService.updatePatient(patientId, patient);
        return new ResponseEntity<>(patient , HttpStatus.OK);
    }

>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
}
