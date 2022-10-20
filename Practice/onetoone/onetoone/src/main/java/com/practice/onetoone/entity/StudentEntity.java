package com.practice.onetoone.entity;

import com.practice.onetoone.model.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "student_onetomany")
public class StudentEntity {
    @Id
    @SequenceGenerator(name = "stu_seq_id", sequenceName = "stu_seq_id", initialValue = 100, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "stu_seq_id")
    private Long id;
    private String fullName;
    private String university;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dep_id")
    private List<DepartmentEntity> departmentEntity;
}
