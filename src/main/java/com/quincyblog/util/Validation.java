package com.quincyblog.util;


import com.quincyblog.dtos.request.BlogPostRequest;
import com.quincyblog.dtos.request.EditBlogRequest;
import com.quincyblog.exceptions.BlogPostException;
import org.springframework.web.multipart.MultipartFile;

public class Validation {
    public static void validateBlog(BlogPostRequest blogPostRequest, MultipartFile multipartFile) throws BlogPostException {
        if (blogPostRequest.getDescription() == null){
            throw new BlogPostException("Description field is empty");
        }

        if (String.valueOf(blogPostRequest.getPostNumber()).isEmpty()){
            throw new BlogPostException("post number is empty");
        }
        if (multipartFile == null){
            throw new BlogPostException("Kindly Provide an image");
        }
    }

    public static void validateEditBlog(EditBlogRequest blogPostRequest) throws BlogPostException {
        if (blogPostRequest.getDescription() == null){
            throw new BlogPostException("Description field is empty");
        }

        if (String.valueOf(blogPostRequest.getPostNumber()).isEmpty()){
            throw new BlogPostException("post number is empty");
        }

    }


}
