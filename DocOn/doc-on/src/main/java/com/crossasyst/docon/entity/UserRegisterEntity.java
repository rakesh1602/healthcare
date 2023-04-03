package com.crossasyst.docon.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column("user_id")
    private Long userId;

    @Column("prefix")
    private String prefix;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("phone_number")
    private Integer phoneNumber;

    @Column("gender")
    private String gender;

    @Column
    private String role;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity accountEntity;
}
