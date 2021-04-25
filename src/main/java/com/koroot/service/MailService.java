package com.koroot.service;

import com.koroot.model.MailDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final ConfigService configService;

    public void mailSend(MailDto mailDto) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(configService.TO_ADDRESS);
        message.setFrom(mailDto.getEmail());
        message.setSubject("[문의사항] " + mailDto.getSubject());

        StringBuffer buffer = new StringBuffer();
        buffer.append("이름 : " + mailDto.getName()).append("\r\n")
                .append("email : " + mailDto.getEmail()).append("\r\n")
                .append("내용 : " + mailDto.getMessage());

        message.setText(buffer.toString());

        mailSender.send(message);
    }
}