package com.ultimatron.erp.dto;

import lombok.Data;

import java.util.List;

@Data
public class InstructionDto {
    private Integer id;
    private String message;
    private List<WorkOrderDto> workOrderDtos;

}
