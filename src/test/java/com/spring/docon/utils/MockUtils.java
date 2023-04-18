package com.spring.docon.utils;

import com.spring.docon.entity.AccountEntity;
import com.spring.docon.entity.PatientEntity;
import com.spring.docon.entity.UserRegisterEntity;

public class MockUtils {

    public static PatientEntity patientEntity(){
        PatientEntity patientEntity=new PatientEntity();
        patientEntity.setPatientId(1L);

        UserRegisterEntity userRegisterEntity=new UserRegisterEntity();
        userRegisterEntity.setFirstName("rajesh");
        userRegisterEntity.setLastName("chavan");

        AccountEntity accountEntity=new AccountEntity();
        accountEntity.setEmailId("rk@gmail.com");
        patientEntity.setUserRegisterEntity(userRegisterEntity);
        patientEntity.getUserRegisterEntity().setAccountEntity(accountEntity);
        return patientEntity;
    }
}
