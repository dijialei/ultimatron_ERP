package com.ultimatron.erp.controllers;

import com.ultimatron.erp.dto.UserDto;
import com.ultimatron.erp.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UsersController {
    private UsersService usersService;
    @PostMapping
    public ResponseEntity addUser(@RequestBody UserDto userDto){
        if (usersService.findUserByEmail(userDto.getEmail()) == null){
            usersService.addUser(userDto);
            return ResponseEntity.status(200).body("user created !");
        }else return ResponseEntity.status(200).body("The email has been registered!");
    }
}
