package com.quincyblog.app;

import com.quincyblog.data.model.Blog;
import com.quincyblog.data.model.Comment;
import com.quincyblog.data.repositories.BlogRepository;
import com.quincyblog.data.repositories.CommentRepository;
import com.quincyblog.dtos.request.CommentRequest;
import com.quincyblog.exceptions.BlogPostException;
import com.quincyblog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentApp implements CommentService {
    private final BlogRepository blogRepository;
    private final CommentRepository commentRepository;
    @Override
    public void makeAComment(Long blogId, CommentRequest commentRequest) throws BlogPostException {
     Blog blog = blogRepository.findById(blogId).orElseThrow(() -> new BlogPostException("Blog not found"));

        List<String> commentList = new ArrayList<>();
        commentList.add(commentRequest.getMessage());



        Comment comments = Comment.builder()
                .name(commentRequest.getName())
                .messages(commentList)
                          .build();

        blog.getComments().add(comments);
        commentRepository.save(comments);
        blogRepository.save(blog);

    }

    @Override
    public List<Comment> findAllComment() {
        return commentRepository.findAll();

    }

    @Override
    public void deleteAll() {
      commentRepository.deleteAll();
    }

    @Override
    public void deleteComment(Long id) throws Exception {
        Comment comment = commentRepository.findById(id).orElseThrow(() -> new BlogPostException("Blog not found"));

        commentRepository.delete(comment);
    }
}
