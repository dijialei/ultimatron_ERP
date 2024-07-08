package com.ultimatron.erp.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String nickName;
    private String email;
    private String password;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @OneToMany(mappedBy = "user")
    private List<WorkOrders> orders;

}
