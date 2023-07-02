package com.springboot.beckend.comment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentResponse {
    private Integer seq;

    public CreateCommentResponse(Integer seq) {
        this.seq = seq;
    }

    
}


