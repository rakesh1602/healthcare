package com.practice.manyTomanyExtraColumn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "extra_employee_entity")
public class EmployeeEntity {
    @Id
    @SequenceGenerator(name = "seq_extra_emp_id", initialValue = 100, sequenceName = "seq_extra_emp_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_extra_emp_id")
    private Long id;
    private String firstName;
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "emp_dept_many_to_many"
            , joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "dept_id", referencedColumnName = "id"))
    private Set<DepartmentEntity> department;
}
