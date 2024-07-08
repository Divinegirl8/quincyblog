package com.quincyblog.service;

import com.quincyblog.data.model.Blog;
import com.quincyblog.dtos.request.BlogPostRequest;
import com.quincyblog.dtos.request.DeleteBlogCommentRequest;
import com.quincyblog.dtos.request.EditBlogImageRequest;
import com.quincyblog.dtos.request.EditBlogRequest;
import com.quincyblog.exceptions.BlogPostException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogService {
    void post(BlogPostRequest request, MultipartFile multipartFile) throws BlogPostException, IOException;
    List<Blog> getAllPost();
    void deleteBlog(Long id) throws BlogPostException;
    void  deleteAllBlog();

    void editBlog(EditBlogRequest editBlogRequest) throws BlogPostException, IOException;
    void  editBlogImage(MultipartFile multipartFile,Long id) throws IOException, BlogPostException;


}
