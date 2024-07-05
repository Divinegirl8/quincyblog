package com.quincyblog.util;


import com.quincyblog.dtos.request.BlogPostRequest;
import com.quincyblog.exceptions.BlogPostException;

public class Validation {
    public static void validateBlog(BlogPostRequest blogPostRequest) throws BlogPostException {
        if (blogPostRequest.getDescription() == null){
            throw new BlogPostException("Description field is empty");
        }

        if (blogPostRequest.getUrl() == null){
            throw new BlogPostException("Image field is empty");
        }
    }
}
