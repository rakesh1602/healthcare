package com.spring.docon.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Date dob;

    @Column(name = "phone_number")
    private Integer phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column
    private String role;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;
}
