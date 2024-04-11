package com.boca.iot.manager.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author lulinwei
 */
public interface FileUploadService {

    String fileUpload(MultipartFile multipartFile);
}
