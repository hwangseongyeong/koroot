package com.koroot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigService {

    public static final String IMAGE_DOWNLOAD_PATH = "/image/download";
    public static final String FILE_DOWNLOAD_PATH = "/file/download";

    @Value("${file.upload-path}")
    public String FILE_DIR_PATH;

    @Value("${file.image.upload-path}")
    public String IMAGE_DIR_PATH;

    @Value("${spring.mail.to-address}")
    public String TO_ADDRESS;
}
