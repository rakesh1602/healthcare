package com.spring.docon.service;

import com.spring.docon.entity.AccountEntity;
import com.spring.docon.entity.PatientEntity;
import com.spring.docon.entity.UserRegisterEntity;
import com.spring.docon.mapper.PatientMapper;
import com.spring.docon.mapper.UserRegisterMapper;
import com.spring.docon.model.Patient;
import com.spring.docon.repository.AccountRepository;
import com.spring.docon.repository.PatientRepository;
import com.spring.docon.repository.UserRepository;
import com.spring.docon.response.PatientResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class PatientService {

    private final PatientRepository patientRepository;

    private final PatientMapper patientMapper;

    private PatientEntity patientEntity;

    @Autowired
    public PatientService(PatientRepository patientRepository, PatientMapper patientMapper) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    public PatientResponse addPatient(Patient patient) {
        patientEntity = patientMapper.modelToEntity(patient);
        patientRepository.save(patientEntity);
        log.info("Patient details saved successfully.");

        PatientResponse patientResponse = new PatientResponse();
        patientResponse.setId(patientEntity.getPatientId());
        log.info("Response id : {}", patientResponse.getId());
        return patientResponse;
    }
}
