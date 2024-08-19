package com.ultimatron.erp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data

public class WorkOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String reference;
    private String client;
    private String model;
    private String sn;
    private LocalDate registrationTime;
    private String description;
    private String result;
    private Boolean replaceAdvance;
    @ManyToOne
    private Users user;
    @OneToMany(mappedBy = "workOrder")
    private List<Records> records;
    @ManyToOne
    private States state;
    @ManyToOne
    private Instructions instruction;
}
