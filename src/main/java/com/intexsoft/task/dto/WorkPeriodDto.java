package com.intexsoft.task.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class WorkPeriodDto {

    @ApiModelProperty("EmloyeeId")
    private Long mitarbeiterId;

    @ApiModelProperty("Begin date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime beginn;

    @ApiModelProperty("End date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime ende;

    @ApiModelProperty("working time in minutes")
    private Long dauer;

}
