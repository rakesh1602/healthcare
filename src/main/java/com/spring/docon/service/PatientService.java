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

import java.util.Base64;
<<<<<<< HEAD
=======
import java.util.List;
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
import java.util.Optional;

@Service
@Log4j2
public class PatientService {
    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    private final EnrollmentService enrollmentService;

    private Patient patient;

<<<<<<< HEAD
    private final Enrollment enrollment = new Enrollment();
=======
    private Enrollment enrollment = new Enrollment();

    private Patient patient;


>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper, EnrollmentService enrollmentService) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
        this.enrollmentService = enrollmentService;
    }

    public PatientResponse addPatient(Patient patient) {
<<<<<<< HEAD
        log.info("Adding patient details.");
        PatientEntity patientEntity = patientMapper.modelToEntity(patient);
=======
        patientEntity = patientMapper.modelToEntity(patient);
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
        patientRepository.save(patientEntity);

        log.info("Patient details saved successfully.");

        enrollmentService.createEnrollment(patientEntity.getPatientId(), enrollment);
        log.info("Create enrollment method has been called.");

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setPatientId(patientEntity.getPatientId());
        log.info("Response id : {}", patientResponse.getPatientId());

        return patientResponse;
    }
<<<<<<< HEAD

    public Patient getPatient(Long patientId) {

        log.info("Finding patient details of patient id {}",patientId);

        Optional<PatientEntity> patientEntity = Optional.ofNullable(patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient details not found for patient id " + patientId)));

        if (patientEntity.isPresent()) {
            patient = patientMapper.entityToModel(patientEntity);
            log.info("Retrieving patient details for the patient id {}", patientId);
        }
        return patient;
    }
=======
    public Patient searchPatient(Long patientId) {
        Optional<PatientEntity> optionalPatientEntity = patientRepository.findById(patientId);
        System.out.println(optionalPatientEntity);

        patient = patientMapper.entityToModel(optionalPatientEntity.get());
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

    public Patient updatePatient(Long patientId, Patient patient) {

        PatientEntity oldPatientEntity = patientRepository.findById(patientId).get();

        UserRegisterEntity userRegisterEntity = oldPatientEntity.getUser();
        Long userId = userRegisterEntity.getUserId();

        AccountEntity accountEntity = oldPatientEntity.getUser().getAccount();
        Long accountId = accountEntity.getAccountId();

        PatientEntity newPatientEntity = patientMapper.modelToEntity(patient);
        newPatientEntity.setPatientId(patientId);
        newPatientEntity.getUser().setUserId(userId);
        newPatientEntity.getUser().getAccount().setAccountId(accountId);
//        accountRepository.save(newPatientEntity.getUser().getAccount());
//        userRepository.save(newPatientEntity.getUser());
        PatientEntity patientEntity1 = patientRepository.save(newPatientEntity);

        Patient patient1 = patientMapper.entityToModel(patientEntity1);
        return patient1;

    }
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
}
