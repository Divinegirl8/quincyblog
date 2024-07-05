package com.quincyblog.app;

import com.quincyblog.data.repositories.BlogRepository;
import com.quincyblog.dtos.request.BlogPostRequest;
import com.quincyblog.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BlogApp implements BlogService {
    private final BlogRepository blogRepository;

    @Override
    public void post(BlogPostRequest request) {

    }
}
