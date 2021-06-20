package com.koroot.service;

import com.koroot.model.LoginDto;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class LoginService {

    public static final String SESSION_NAME = "ADMIN";

    public void setLogin(HttpServletRequest request, LoginDto loginDto) {
        HttpSession session = request.getSession();
        session.setAttribute(SESSION_NAME, loginDto);
        session.setMaxInactiveInterval(86400);
    }

    public LoginDto getLogin(HttpServletRequest request) {

        return (LoginDto) request.getSession().getAttribute(SESSION_NAME);
    }

    public boolean isLogin(HttpServletRequest request) {
        if (Objects.nonNull(request.getSession().getAttribute(SESSION_NAME))) {
            return true;
        }
        return false;
    }
}
