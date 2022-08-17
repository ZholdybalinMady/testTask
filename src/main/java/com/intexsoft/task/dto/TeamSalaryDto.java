package com.intexsoft.task.dto;

import com.intexsoft.task.entity.Employee;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TeamSalaryDto {
    private List<EmployeeDto> employees;
    private Float totalAmount;
}
