package com.quincyblog.app;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.quincyblog.data.model.Image;
import com.quincyblog.data.repositories.ImageRepository;
import com.quincyblog.dtos.response.UploadImageResponse;
import com.quincyblog.service.CloudinaryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@AllArgsConstructor
public class CloudinaryApp implements CloudinaryService {
    private final ImageRepository imageRepository;
    private final Cloudinary cloudinary;

    @Override
    public UploadImageResponse uploadImage(MultipartFile multipartFile) throws IOException {
     Map uploadFile = cloudinary.uploader()
             .upload(multipartFile.getBytes(), ObjectUtils.emptyMap());
     saveFile(uploadFile);

     UploadImageResponse uploadImageResponse = new UploadImageResponse();
     uploadImageResponse.setUrl(uploadFile.get("url").toString());

        return uploadImageResponse;
    }

    private void saveFile(Map uploadFile){
        Image image = Image.builder()
                .url(uploadFile.get("url").toString())
                .build();

        imageRepository.save(image);
    }
}
