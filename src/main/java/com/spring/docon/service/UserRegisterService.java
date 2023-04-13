package com.spring.docon.service;

import com.spring.docon.entity.AccountEntity;
import com.spring.docon.entity.UserRegisterEntity;
import com.spring.docon.mapper.AccountMapper;
import com.spring.docon.mapper.UserRegisterMapper;
import com.spring.docon.model.Account;
import com.spring.docon.model.UserRegister;
import com.spring.docon.repository.AccountRepository;
import com.spring.docon.repository.UserRepository;
import com.spring.docon.response.UserResponse;
import com.spring.docon.util.PasswordGenerator;
import lombok.extern.log4j.Log4j2;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
@Log4j2
public class UserRegisterService {

    UserRegisterEntity userRegisterEntity;

    private final UserRegisterMapper userRegisterMapper;

    private final UserRepository userRepository;

    private final AccountRepository accountEntityRepository;

    private final AccountMapper accountMapper;

    private Account account = new Account();

    @Autowired
    private final KafkaTemplate<String, JSONObject> kafkaTemplate;

    @Value("${topic.name.producer}")
    private String topicName;

    @Autowired
    public UserRegisterService(UserRegisterMapper userRegisterMapper, UserRepository userRepository, AccountRepository accountEntityRepository, AccountMapper accountMapper, KafkaTemplate<String, JSONObject> kafkaTemplate) {
        this.userRegisterMapper = userRegisterMapper;
        this.userRepository = userRepository;
        this.accountEntityRepository = accountEntityRepository;
        this.accountMapper = accountMapper;
        this.kafkaTemplate = kafkaTemplate;
    }

    public UserResponse addUser(UserRegister userRegister) {
        userRegisterEntity = userRegisterMapper.modelToEntity(userRegister);

        String randomPassword = PasswordGenerator.generateRandomPassword(8);
        log.info("Random password {}", randomPassword);

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setPassword(randomPassword);
        accountEntity.setEmailId(userRegister.getAccount().getEmailId());

        userRegisterEntity.setAccountEntity(accountEntity);
        accountEntityRepository.save(accountEntity);

        userRepository.save(userRegisterEntity);
        log.info("user details saved successfully");

        UserResponse userResponse = new UserResponse();
        userResponse.setId(userRegisterEntity.getUserId());

        if (userRegisterEntity.getAccountEntity().getAccountId() != null) {
            Long accountId = userRegisterEntity.getAccountEntity().getAccountId();
            log.info(accountId + " account id");
            getAccounts(accountId);
        }
        return userResponse;
    }

    public Account getAccounts(Long accountId) {
        AccountEntity accountEntity = accountEntityRepository.findById(userRegisterEntity.getAccountEntity().getAccountId())
                .orElseThrow(() -> new RuntimeException("Account id not found " + accountId));

        if (accountEntity != null) {
            account = accountMapper.entityToModel(accountEntity);
            log.info("Account details found");
        }
        return account;
    }
}
