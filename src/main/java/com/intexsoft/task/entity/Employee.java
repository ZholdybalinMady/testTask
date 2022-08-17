package com.intexsoft.task.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    private Long mitarbeiterId;

    @Column
    private Long salary;

    @Column
    private Long teamId;


}
