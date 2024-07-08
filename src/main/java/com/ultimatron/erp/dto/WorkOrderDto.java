package com.ultimatron.erp.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkOrderDto {
    private Integer id;
    private String reference;
    private String client;
    private String model;
    private String sn;
    private LocalDateTime registrationTime;
    private String description;
    private String result;
    private Boolean replaceAdvance;
    private UserDto userDto;
    private List<RecordDto> recordDtos;
    private StateDto stateDto;
    private InstructionDto instructionDto;
}
