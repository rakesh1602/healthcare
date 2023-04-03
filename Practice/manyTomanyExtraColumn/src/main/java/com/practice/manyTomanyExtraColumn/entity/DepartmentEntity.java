package com.practice.manyTomanyExtraColumn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "extra_department_many_to_many")
public class DepartmentEntity {
    @Id
    @SequenceGenerator(name = "seq_dept_id", initialValue = 1, sequenceName = "seq_dept_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dept_id")
    private Long id;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "department")
    private Set<EmployeeEntity> employee;

    @OneToMany(mappedBy = "departmentEntity", cascade = CascadeType.ALL)
    private Set<DepEmpEntity> depEmpEntities=new HashSet<>();
}
