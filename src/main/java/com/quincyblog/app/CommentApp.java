package com.quincyblog.app;

import com.quincyblog.dtos.request.CommentRequest;
import com.quincyblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentApp implements CommentService
{
    @Override
    public void makeAComment(Long blogId, CommentRequest commentRequest) {

    }
}
