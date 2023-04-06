package com.spring.docon.service;

import com.spring.docon.entity.AccountEntity;
import com.spring.docon.entity.EnrollmentEntity;
import com.spring.docon.entity.PatientEntity;
import com.spring.docon.entity.UserRegisterEntity;
import com.spring.docon.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, UserRegisterEntity> userRegisterEntityKafkaTemplate;

    private final KafkaTemplate<String, AccountEntity> accountEntityKafkaTemplate;

    private final KafkaTemplate<String, EnrollmentEntity> enrollmentEntityKafkaTemplate;

    private UserRegisterEntity userRegisterEntity=new UserRegisterEntity();

    private AccountEntity accountEntity=new AccountEntity();

    private PatientEntity patientEntity=new PatientEntity();

    private PatientRepository patientRepository;

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, UserRegisterEntity> userRegisterEntityKafkaTemplate, KafkaTemplate<String, AccountEntity> accountEntityKafkaTemplate, KafkaTemplate<String, EnrollmentEntity> enrollmentEntityKafkaTemplate, PatientRepository patientRepository) {
        this.userRegisterEntityKafkaTemplate = userRegisterEntityKafkaTemplate;
        this.accountEntityKafkaTemplate = accountEntityKafkaTemplate;
        this.enrollmentEntityKafkaTemplate = enrollmentEntityKafkaTemplate;
        this.patientRepository = patientRepository;
    }

    public void producer(UserRegisterEntity userRegisterEntity, AccountEntity accountEntity, EnrollmentEntity enrollmentEntity) {
        PatientEntity patientEntity1 = patientRepository.findById(enrollmentEntity.getPatientEntity().getPatientId()).get();
        userRegisterEntity.setAccountEntity(patientEntity1.getUserRegisterEntity().getAccountEntity());
        patientEntity1.setUserRegisterEntity(enrollmentEntity.getPatientEntity().getUserRegisterEntity());
        userRegisterEntityKafkaTemplate.send(topicName, "user", userRegisterEntity);
        accountEntityKafkaTemplate.send(topicName, "account", accountEntity);
        enrollmentEntityKafkaTemplate.send(topicName, "enrollment", enrollmentEntity);
    }
}
