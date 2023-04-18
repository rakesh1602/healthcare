package com.spring.docon.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.text.SimpleDateFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class UserRegisterEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "prefix")
    private String prefix;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @DateTimeFormat(pattern = "YYYY-mm-dd")
    private Date dob;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column
    private String role;

    private Boolean deleted = Boolean.FALSE;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
<<<<<<< HEAD
    private AccountEntity accountEntity;

    public UserRegisterEntity(long userId, String mr, String rakesh, String chavan, String s, int phoneNumber, String male, String admin, AccountEntity accountEntity) {
    }
=======
    private AccountEntity account;
>>>>>>> f62aa9d4d01904d6d20b8362e2e2151384f69f11
}
