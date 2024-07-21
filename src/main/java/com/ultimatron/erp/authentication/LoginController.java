package com.ultimatron.erp.authentication;

import com.ultimatron.erp.config.JwtConfig;
import com.ultimatron.erp.dto.UserDto;
import com.ultimatron.erp.entities.Users;
import com.ultimatron.erp.utils.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class LoginController {
    private LoginService loginService;
    private JwtUtil jwtUtil;
    private JwtConfig jwtConfig;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Users user) {
        return loginService.login(user);
    }

    @GetMapping("/signout")
    public ResponseEntity signout(@RequestHeader HttpHeaders httpHeaders) {
        return loginService.signout(httpHeaders);
    }

}
