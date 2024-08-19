package com.ultimatron.erp.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class RecordDto {
    private Integer id;
    private String record;
    private LocalDateTime recordTime;
    private Integer workOrderId;
}
