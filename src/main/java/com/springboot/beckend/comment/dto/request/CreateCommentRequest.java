package com.springboot.beckend.comment.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {

    private String id;
    private String content;
    
}
