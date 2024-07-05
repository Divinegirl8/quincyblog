package com.quincyblog.service;

import com.quincyblog.dtos.request.BlogPostRequest;

public interface BlogService {
    void post(BlogPostRequest request);
}
