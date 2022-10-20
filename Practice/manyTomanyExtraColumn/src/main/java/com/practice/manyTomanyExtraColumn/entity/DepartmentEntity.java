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
@Table(name = "extra_dep_entity")
public class DepartmentEntity {
    @Id
    @SequenceGenerator(name = "seq_extra_dept_id", initialValue = 1000, sequenceName = "seq_extra_dept_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_extra_dept_id")
    private Long id;
    private String depName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, mappedBy = "department")
    private Set<EmployeeEntity> Employee;
}
