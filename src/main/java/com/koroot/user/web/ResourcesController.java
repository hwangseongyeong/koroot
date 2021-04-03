package com.koroot.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 자료실
 */
@Controller
public class ResourcesController {

    /**
     * 발간 자료
     */
    @GetMapping("/resources/publication")
    public String publication(){
        return "content/resources/publication";
    }
    /**
     * 영상 자료
     */
    @GetMapping("/resources/video")
    public String video(){
        return "content/resources/video";
    }
    /**
     * 해외입양인 커뮤니티
     */
    @GetMapping("/resources/community")
    public String community(){
        return "content/resources/community";
    }
}
