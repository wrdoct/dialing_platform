package com.boca.iot.platform.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lulinwei
 */
public interface FileUploadService {

    String fileUpload(MultipartFile multipartFile);
}
