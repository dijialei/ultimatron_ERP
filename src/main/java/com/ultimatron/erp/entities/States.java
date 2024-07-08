package com.ultimatron.erp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String state;
    @OneToMany(mappedBy = "state")
    private List<WorkOrders> workOrders;

}
