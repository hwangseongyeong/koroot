package com.koroot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 출판
 */
@Controller
public class PublishingController {

    /**
     * 발간 도서
     */
    @GetMapping("/publishing/books")
    public String books(){
        return "content/publishing/books";
    }
    /**
     * 책 이야기
     */
    @GetMapping("/publishing/book-story")
    public String bookStory(){
        return "content/publishing/bookStory";
    }
}
