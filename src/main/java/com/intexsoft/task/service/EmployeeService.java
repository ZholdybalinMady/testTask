package com.intexsoft.task.service;

import com.intexsoft.task.dto.EmployeeDto;
import com.intexsoft.task.dto.TeamSalaryDto;
import com.intexsoft.task.dto.WorkPeriodDto;
import com.intexsoft.task.entity.Employee;
import com.intexsoft.task.entity.WorkPeriod;
import com.intexsoft.task.repository.EmployeeRepository;
import com.intexsoft.task.repository.WorkPeriodRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.YearMonth;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private WorkPeriodRepository workPeriodRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Transactional
    public void processTotalAmount(YearMonth yearMonth, WorkPeriodDto workPeriodDto) {
        log.info("processTotalAmount for employee {}", workPeriodDto.getMitarbeiterId());
        Employee employee = employeeRepository.findById(workPeriodDto.getMitarbeiterId()).orElseThrow(() -> new RuntimeException("employee by id not found"));
        float hours = (float) workPeriodDto.getDauer() / 60;
        float daySalary = hours * employee.getSalary();

        WorkPeriod workPeriod = WorkPeriod.builder()
                .workYear(Long.valueOf(yearMonth.getYear()))
                .workMonth(Long.valueOf(yearMonth.getMonth().getValue()))
                .employee(employee)
                .daySalary(daySalary)
                .teamId(employee.getTeamId())
                .build();

        workPeriodRepository.save(workPeriod);
        log.info("WorkPeriod for employee {} saved by Id {}", workPeriodDto.getMitarbeiterId(), workPeriod.getId());
    }

    @Transactional(readOnly = true)
    public List<EmployeeDto> getTeamSalary(Long teamId) {
        log.info("Getting total salary amount for team {}", teamId);
        List<WorkPeriod> workPeriods = workPeriodRepository.findByTeamId(teamId);

        List<EmployeeDto> employeeDtos = workPeriods.stream().map(workPeriod -> {
                    return EmployeeDto.builder().id(workPeriod.getEmployee().getMitarbeiterId()).salary(workPeriod.getDaySalary()).build();
                }
        ).collect(Collectors.toList());
        return employeeDtos;


    }

}
