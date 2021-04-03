package com.koroot.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 활동
 */
@Controller
public class ActivityController {

    /**
     * 사업 방향
     */
    @GetMapping("/activity/business-direction")
    public String businessDirection(){
        return "content/activity/businessDirection";
    }
    /**
     * 진행중인 주요사업 - 게스트 하우스
     */
    @GetMapping("/activity/guest-house")
    public String guestHouse(){
        return "content/activity/guestHouse";
    }
    /**
     * 진행중인 주요사업 - 모국생활지원
     */
    @GetMapping("/activity/life-support")
    public String lifeSupport(){
        return "content/activity/lifeSupport";
    }
    /**
     * 진행중인 주요사업 - 권익옹호사업
     */
    @GetMapping("/activity/advocacy")
    public String advocacy(){
        return "content/activity/advocacy";
    }
    /**
     * 진행중인 주요사업 - 연구사업
     */
    @GetMapping("/activity/research")
    public String research(){
        return "content/activity/research";
    }
    /**
     * 진행중인 주요사업 - 지난사업 아카이브
     */
    @GetMapping("/activity/archive")
    public String archive(){
        return "content/activity/archive";
    }
}
