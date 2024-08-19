package com.ultimatron.erp.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class WorkOrderDto {
    private Integer id;
    private String reference;
    private String client;
    private String model;
    private String sn;
    private LocalDate registrationTime;
    private String description;
    private String result;
    private Boolean replaceAdvance;
    private Integer userId;
    private List<RecordDto> records;
    private Integer stateId;
    private Integer instructionId;
}
