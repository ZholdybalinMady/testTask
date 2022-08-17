package com.intexsoft.task.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class EmployeeDto {

    @ApiModelProperty("employee Id")
    private Long id;

    @ApiModelProperty("employee salary per hour")
    private Float salary;




}
