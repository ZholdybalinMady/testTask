package com.intexsoft.task.controller;

import com.intexsoft.task.dto.EmployeeDto;
import com.intexsoft.task.dto.TeamSalaryDto;
import com.intexsoft.task.dto.WorkPeriodDto;
import com.intexsoft.task.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.Description;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.List;

@RestController("/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @ApiOperation("Receive all employees work periods")
    @PostMapping("period/{yearMonth}")
    public void receiveDataByTask(@DateTimeFormat(pattern = "yyyy-MM") @PathVariable YearMonth yearMonth, @RequestBody WorkPeriodDto workPeriodDto ){
        employeeService.processTotalAmount(yearMonth, workPeriodDto);
    }

    @ApiOperation("Team employee ")
    @GetMapping("salary/{teamId}")
    public List<EmployeeDto> getTeamSalary(@PathVariable Long teamId){
        return employeeService.getTeamSalary(teamId);
    }


}
