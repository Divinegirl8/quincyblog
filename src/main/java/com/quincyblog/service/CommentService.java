package com.quincyblog.service;

import com.quincyblog.dtos.request.CommentRequest;

public interface CommentService {
    void makeAComment(Long blogId, CommentRequest commentRequest);
}
