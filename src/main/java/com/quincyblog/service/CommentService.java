package com.quincyblog.service;

import com.quincyblog.data.model.Comment;
import com.quincyblog.dtos.request.CommentRequest;
import com.quincyblog.exceptions.BlogPostException;

import java.util.List;

public interface CommentService {
    void makeAComment(Long blogId, CommentRequest commentRequest) throws BlogPostException;
    List<Comment> findAllComment();
}
