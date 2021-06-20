package com.koroot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 커뮤니케이션
 */
@Controller
public class CommunicationController {

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
    /**
     * FAQ(영문)
     */
    @GetMapping("/eng/communication/faq")
    public String engFaq(){
        return "content/communication/engFaq";
    }
}
