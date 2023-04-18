package com.spring.docon.service;

import com.spring.docon.entity.AccountEntity;
import com.spring.docon.entity.PatientEntity;
import com.spring.docon.entity.UserRegisterEntity;
import com.spring.docon.mapper.PatientMapper;
import com.spring.docon.model.Enrollment;
import com.spring.docon.model.Patient;
import com.spring.docon.repository.PatientRepository;
import com.spring.docon.response.PatientResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class PatientService {
    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    private final EnrollmentService enrollmentService;

    private PatientEntity patientEntity;

    private Enrollment enrollment = new Enrollment();

    private Patient patient;



    @Autowired
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, EnrollmentService enrollmentService) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.enrollmentService = enrollmentService;
    }

    public PatientResponse addPatient(Patient patient) {
        log.info("Adding patient details.");
        patientEntity = patientMapper.modelToEntity(patient);
        patientEntity.getUserRegisterEntity().getAccountEntity().setPassword(Base64.getEncoder().encodeToString(patientEntity.getUserRegisterEntity().getAccountEntity().getPassword().getBytes()));
        patientRepository.save(patientEntity);
        log.info("Patient details saved successfully.");

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patientEntity.getPatientId());
        log.info("Response id : {}", patientResponse.getId());

        enrollmentService.createEnrollment(patientEntity.getPatientId(), enrollment);
        log.info("Create enrollment method has been called.");

        return patientResponse;
    }
    public Patient searchPatient(Long patientId) {
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(patientId);
        System.out.println(optionalPatientEntity);

        patient = patientMapper.toModel(optionalPatientEntity.get());
        log.info("Search patient with patientId {}", patient);

        return patient;
    }

    public List<Patient> getAllPatients() {
        List<PatientEntity> patientEntities = patientRepository.findAll();
        List<Patient> patients = patientMapper.toModels(patientEntities);
        return patients;
    }

    public void deleteById(Long patientId) {
        patientRepository.findByPatientIdAndDeleteFalse(patientId);
    }

    //    public Patient updatePatient(Long patientId, Patient patient) {
//
//        PatientEntity patientEntity1 = patientRepository.findById(patientId).get();
//
//        PatientEntity patient1 = patientMapper.modelToEntity(patient);
//
//        patient1.setPatientId(patientEntity.getPatientId());
//        patientRepository.save(patient1);
//        log.info("Patient updated where id is:" + patientId);
//        return patient;
//    }
//    public Patient updatePatient(Long patientId, Patient patient){
//        PatientEntity oldPatientEntity = patientRepository.findById(patientId).get();
//
//        UserRegisterEntity userRegisterEntity = oldPatientEntity.getUser();
//        Long userId = userRegisterEntity.getUserId();
//
//        AccountEntity accountEntity = oldPatientEntity.getUser().getAccount();
//        Long accountId = accountEntity.getAccountId();
//
//        PatientEntity newPatientEntity = patientMapper.modelToEntity(patient);
//        newPatientEntity.setPatientId(patientId);
//        newPatientEntity.getUser().setUserId(userId);
//        newPatientEntity.getUser().getAccount().setAccountId(accountId);
//
//        PatientEntity patientEntity1 = patientRepository.save(newPatientEntity);
//
//        Patient patient1 = patientMapper.toModel(patientEntity1);
//
//        return patient1;
//
//    }
}
