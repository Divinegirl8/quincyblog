package com.quincyblog.data.repositories;

import com.quincyblog.data.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
Image findImageByUrl(String url);
}
