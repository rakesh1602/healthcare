package com.spring.docon.service;

import com.spring.docon.entity.AccountEntity;
<<<<<<< HEAD
import com.spring.docon.entity.EnrollmentEntity;
import com.spring.docon.model.patch.Password;
import com.spring.docon.repository.AccountRepository;
import com.spring.docon.repository.EnrollmentRepository;
import com.spring.docon.response.PasswordResponse;
import com.spring.docon.response.PersonValidateResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Base64;
import java.util.UUID;

@Service
@Log4j2
=======
import com.spring.docon.mapper.AccountMapper;
import com.spring.docon.model.Account;
import com.spring.docon.repository.AccountRepository;
import com.spring.docon.response.AccountResponse;

>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
public class AccountService {

    private final AccountRepository accountRepository;

<<<<<<< HEAD
    private final EnrollmentRepository enrollmentRepository;

    private AccountEntity accountEntity = new AccountEntity();
    private PersonValidateResponse personValidateResponse = new PersonValidateResponse();

    private PasswordResponse passwordResponse = new PasswordResponse();

    public AccountService(AccountRepository accountRepository, EnrollmentRepository enrollmentRepository) {
        this.accountRepository = accountRepository;
        this.enrollmentRepository = enrollmentRepository;
    }

    public PasswordResponse createPassword(UUID enrollmentId, Password password, String emailId, Date dob) {
        EnrollmentEntity enrollmentEntity = enrollmentRepository.findByUUID(enrollmentId);

        String email = enrollmentEntity.getPatientEntity().getUserRegisterEntity().getAccountEntity().getEmailId();
        Date dateOfBirth = enrollmentEntity.getPatientEntity().getUserRegisterEntity().getDob();

        if (email.equals(emailId) && dob.equals(dateOfBirth)) {
            log.info("Inside the create password method");
            enrollmentEntity.getPatientEntity().getUserRegisterEntity().getAccountEntity().setPassword(Base64.getEncoder().encodeToString(password.getPassword().getBytes()));
            accountRepository.save(accountEntity);
        } else {
            throw new RuntimeException("Email id or password does not valid.");
        }
        passwordResponse.setMessage("Your password has been created successfully!");
        return passwordResponse;
=======
    private final AccountMapper accountMapper;

    public AccountService(AccountRepository accountRepository, AccountMapper accountMapper) {
        this.accountRepository = accountRepository;
        this.accountMapper = accountMapper;
    }

    public AccountResponse addAccount(Account account) {
        AccountEntity accountEntity = accountMapper.modelToEntity(account);
        accountRepository.save(accountEntity);

        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setAccountId(accountEntity.getAccountId());

        return accountResponse;

>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
    }
}
