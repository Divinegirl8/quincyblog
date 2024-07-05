package com.quincyblog.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditBlogRequest {
    private Long id;
    private String description;
    private String postNumber;
}
