package com.koroot.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailDto {
    private String name;
    private String email;
    private String subject;
    private String message;
}
