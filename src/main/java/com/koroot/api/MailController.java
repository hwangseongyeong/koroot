package com.koroot.api;

import com.koroot.model.MailDto;
import com.koroot.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class MailController {

    private final MailService mailService;

    @PostMapping("/mail")
    public boolean mail(@RequestBody MailDto mailDto) throws Exception{

        mailService.mailSend(mailDto);

        return true;
    }
}
