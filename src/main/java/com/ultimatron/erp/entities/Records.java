package com.ultimatron.erp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String record;
    private LocalDateTime recordTime;
    @ManyToOne
    private WorkOrders workOrder;
}
