package com.koroot.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 커뮤니케이션
 */
@Controller
public class CommunicationController {

    /**
     * 공지
     */
    @GetMapping("/communication/notice")
    public String main(){
        return "content/communication/notice";
    }
    /**
     * 언론보도
     */
    @GetMapping("/communication/press")
    public String press(){
        return "content/communication/press";
    }
    /**
     * 해외입양인 목소리
    */
    @GetMapping("/communication/voice")
    public String voice(){
        return "content/communication/voice";
    }
    /**
     * 김도현 목사의 해외입양 이야기
     */
    @GetMapping("/communication/story")
    public String story(){
        return "content/communication/story";
    }
    /**
     * 문의하기
     */
    @GetMapping("/communication/question")
    public String question(){
        return "content/communication/question";
    }
}
