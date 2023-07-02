package com.springboot.beckend.comment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCommentResponse {
    private Integer deletedcheck;

    public DeleteCommentResponse(Integer deletedcheck) {
        this.deletedcheck = deletedcheck;
    }

    
}
