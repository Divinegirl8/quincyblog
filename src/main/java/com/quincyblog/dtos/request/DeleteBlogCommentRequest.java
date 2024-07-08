package com.quincyblog.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteBlogCommentRequest {
    private Long blogId;
    private Long commentId;
}
