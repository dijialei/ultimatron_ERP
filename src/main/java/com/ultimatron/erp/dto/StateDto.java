package com.ultimatron.erp.dto;

import lombok.Data;

import java.util.List;

@Data
public class StateDto {
    private Integer id;
    private String state;
    private List<WorkOrderDto> workOrderDtos;

}
