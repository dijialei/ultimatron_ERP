package com.ultimatron.erp.services;

import com.ultimatron.erp.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UsersService {
    private UsersRepository usersRepository;
}
