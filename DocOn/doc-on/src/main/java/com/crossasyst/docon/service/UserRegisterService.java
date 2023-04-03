package com.crossasyst.docon.service;

import com.crossasyst.docon.entity.AccountEntity;
import com.crossasyst.docon.mapper.UserRegisterMapper;
import com.crossasyst.docon.model.UserRegister;
import com.crossasyst.docon.repository.AccountRepository;
import com.crossasyst.docon.repository.UserRegisterRepository;
import com.crossasyst.docon.response.UserRegisterResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
@Log4j2
public class UserRegisterService {

    @Autowired
    private final UserRegisterMapper userRegisterMapper;

    private final UserRegisterRepository userRegisterRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    public UserRegisterService(UserRegisterMapper userRegisterMapper, UserRegisterRepository userRegisterRepository) {
        this.userRegisterMapper = userRegisterMapper;
        this.userRegisterRepository = userRegisterRepository;
    }

  /*  public Mono<UserRegisterResponse> addPatient(Mono<UserRegister> userRegister) {
        log.info("Adding patient details");
        return userRegister.map(userRegisterMapper::modelToEntity)
                .flatMap(this.userRegisterRepository::save)
                .map(userRegisterMapper::response).log("User details saved successfully");
    }*/


    @Transactional
    public Mono<UserRegisterResponse> addPatient(Mono<UserRegister> userRegister) {
        log.info("Adding patient details");
        return userRegister.map(userRegisterMapper::modelToEntity)
                .flatMap(userRegisterEntity -> {
                    AccountEntity accountEntity = userRegisterEntity.getAccountEntity();
                    return accountRepository.save(accountEntity)
                            .flatMap(savedAccountEntity -> {
                                userRegisterEntity.setAccountEntity(savedAccountEntity);
                                return userRegisterRepository.save(userRegisterEntity);
                            });
                })
                .map(userRegisterMapper::response)
                .log("user details saved successfully");
    }

}
