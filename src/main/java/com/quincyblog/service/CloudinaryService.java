package com.quincyblog.service;

import com.quincyblog.dtos.response.UploadImageResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CloudinaryService {
    UploadImageResponse uploadImage(MultipartFile multipartFile) throws IOException;
}
