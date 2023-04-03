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
@Table(name = "extra_employee_many_to_many")
public class EmployeeEntity {
    @Id
    @SequenceGenerator(name = "seq_emp_id", initialValue = 1, sequenceName = "seq_emp_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_emp_id")
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "emp_dept_many_to_many"
            , joinColumns = @JoinColumn(name = "emp_id", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "dept_id", referencedColumnName = "id"))
   private Set<DepartmentEntity> department;

    @OneToMany(mappedBy = "employeeEntity", cascade = CascadeType.ALL)
    private Set<DepEmpEntity> depEmpEntities;


}
