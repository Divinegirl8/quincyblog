package com.quincyblog.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommentRequest {
    private String name;
    private String message;
}
