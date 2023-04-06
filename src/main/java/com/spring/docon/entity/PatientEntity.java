package com.spring.docon.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class PatientEntity {

    @Id
    @GeneratedValue
    @Column(name = "patient_id")
    private Long patientId;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "height")
    private String height;

    @Column(name = "weight")
    private String weight;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private UserRegisterEntity userRegisterEntity;
}




