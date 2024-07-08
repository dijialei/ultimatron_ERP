package com.ultimatron.erp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Instructions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    @OneToMany(mappedBy = "instruction")
    private List<WorkOrders> workOrders;
}
