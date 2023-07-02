package com.springboot.beckend.comment.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {
    private Integer bulSeq;
    private Integer page;   
}
