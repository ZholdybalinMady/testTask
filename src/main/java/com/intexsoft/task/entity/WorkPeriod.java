package com.intexsoft.task.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "WORK_PERIOD")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkPeriod {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime workDate;
    private Long workYear;
    private Long workMonth;

    private Float daySalary;

    @ManyToOne()
    private Employee employee;
    private Long teamId;







}
