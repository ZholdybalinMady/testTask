package com.intexsoft.task.service;

import com.intexsoft.task.dto.EmployeeDto;
import com.intexsoft.task.dto.WorkPeriodDto;
import com.intexsoft.task.entity.Employee;
import com.intexsoft.task.entity.WorkPeriod;
import com.intexsoft.task.repository.WorkPeriodRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.YearMonth;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;


    @BeforeEach
    void initMocks(){

    }

    @Test
    void processTotalAmount() {
        YearMonth yearMonth = YearMonth.of(2022, Month.MARCH);
        WorkPeriodDto workPeriod = new WorkPeriodDto();
        workPeriod.setMitarbeiterId(1L);
        LocalDateTime begin = LocalDateTime.of(2022, Month.MARCH, 1, 9, 0);
        workPeriod.setBeginn(begin);
        LocalDateTime end = LocalDateTime.of(2022, Month.MARCH, 1, 18, 0);
        workPeriod.setEnde(end);
        workPeriod.setDauer(480L);

        employeeService.processTotalAmount(yearMonth, workPeriod);
    }


    @Test
    void getTeamSalary(){
        List<EmployeeDto> employeeDtos = employeeService.getTeamSalary(1L);
        assertNotNull(employeeDtos);
        assertTrue(employeeDtos.size()>0);
        System.out.println(employeeDtos);
    }

    @Test()
    void test(){
        processTotalAmount();
        getTeamSalary();
    }

}
