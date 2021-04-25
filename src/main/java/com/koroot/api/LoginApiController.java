package com.koroot.api;


import com.koroot.model.LoginDto;
import com.koroot.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/login")
public class LoginApiController {

    private final LoginService loginService;

    private static final String ADMIN_USER_NAME = "admin";
    private static final String ADMIN_PASSWORD = "koroot2452";

    @PostMapping
    public boolean login(@RequestBody LoginDto loginDto, HttpServletRequest request) {

        if (ADMIN_USER_NAME.equals(loginDto.getUserName()) && ADMIN_PASSWORD.equals(loginDto.getPassword())) {
            loginService.setLogin(request, loginDto);
            return true;
        }

        return false;
    }
}
