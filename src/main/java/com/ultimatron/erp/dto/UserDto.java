package com.ultimatron.erp.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.FetchType;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Integer id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    private List<String> roles;
    private List<WorkOrderDto> workOrderDtos;
}
