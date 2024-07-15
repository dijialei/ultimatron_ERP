package com.ultimatron.erp.services;

import com.ultimatron.erp.dto.UserDto;
import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.mapper.UsersMapper;
import com.ultimatron.erp.repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Transactional
public class UsersService {
    private UsersRepository usersRepository;
    private PasswordEncoder encoder;
    private UsersMapper usersMapper;
    public Users addUser(UserDto userDto){
        userDto.setPassword(encoder.encode(userDto.getPassword()));
        return usersRepository.save(usersMapper.toUsers(userDto));
    }
    public Users findUserByEmail(String email){
        return usersRepository.findUsersByEmail(email).orElse(null);
    }
}
