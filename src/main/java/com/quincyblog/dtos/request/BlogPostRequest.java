package com.quincyblog.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BlogPostRequest {
    private String url;
    private String description;
}
