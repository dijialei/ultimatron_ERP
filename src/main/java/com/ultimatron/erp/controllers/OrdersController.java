package com.ultimatron.erp.controllers;

import com.ultimatron.erp.authentication.LoginUser;
import com.ultimatron.erp.dto.WorkOrderDto;
import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.entities.WorkOrders;
import com.ultimatron.erp.services.WorkOrdersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
@AllArgsConstructor
public class OrdersController {
    private WorkOrdersService ordersService;

    @PostMapping
    public ResponseEntity addOrder(@RequestBody WorkOrders order) {
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = loginUser.getUser();
        order.setUser(user);
        ordersService.addOrder(order);
        return ResponseEntity.status(200).body("created!");
    }
    @GetMapping
    public ResponseEntity<List<WorkOrderDto>> findAllById(){
        LoginUser loginUser = (LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Users user = loginUser.getUser();
        Integer id = user.getId();
        return ResponseEntity.status(200).body( ordersService.findAllById(id));
    }
}
