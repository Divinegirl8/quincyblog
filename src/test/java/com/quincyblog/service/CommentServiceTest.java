package com.quincyblog.service;

import com.quincyblog.data.model.Comment;
import com.quincyblog.dtos.request.CommentRequest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class CommentServiceTest {
    @Autowired
     private CommentService commentService;

    @Test void test_THat_Comment_Can_Be_Made() throws Exception{
        CommentRequest commentRequest = new CommentRequest();

        commentRequest.setName("name");
        commentRequest.setMessage("nice message");

        commentService.makeAComment(1L,commentRequest);

    }

    @Test void test_Find_All_Blog(){
        List<Comment> commentList = commentService.findAllComment();
        log.info("{} ->",commentList);
    }

}