package com.koroot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 단체소개
 */
@Controller
public class IntroController {

    /**
     * 인사말
     */
    @GetMapping("/intro/greetings")
    public String greetings(){
        return "content/intro/greetings";
    }
    /**
     * 설립 목적
     */
    @GetMapping("/intro/establishment")
    public String establishment(){
        return "content/intro/establishment";
    }
    /**
     * 연혁
     */
    @GetMapping("/intro/history")
    public String history(){
        return "content/intro/history";
    }
    /**
     * 함께하는 사람들
     */
    @GetMapping("/intro/people")
    public String people(){
        return "content/intro/people";
    }
    /**
     * 연차 보고서
     */
    @GetMapping("/intro/annual")
    public String annual(){
        return "content/intro/annual";
    }
    /**
     * 투명한재정,회계보고
     */
    @GetMapping("/intro/accounting")
    public String accounting(){
        return "content/intro/accounting";
    }
    /**
     * 찾아오시는 길
     */
    @GetMapping("/intro/directions")
    public String main(){
        return "content/intro/directions";
    }
}
