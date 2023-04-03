package com.practice.manyTomanyExtraColumn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "extra_depemp_entity")
public class DepEmpEntity {
    @Id
    @SequenceGenerator(name = "seq_deptemp_id", initialValue = 1, sequenceName = "seq_deptemp_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_deptemp_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extra_emp_id", referencedColumnName = "id")
    private EmployeeEntity employeeEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_id", referencedColumnName = "id")
    private DepartmentEntity departmentEntity;

    private Date date;


}
