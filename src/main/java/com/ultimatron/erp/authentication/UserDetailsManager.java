package com.ultimatron.erp.authentication;

import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.services.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@AllArgsConstructor
public class UserDetailsManager implements UserDetailsService {
    private UsersService usersService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> loginUser = Optional.ofNullable(usersService.findUserByEmail(username));
        return new LoginUser(loginUser.orElseThrow(()-> new RuntimeException("No such user !")));
    }
}
