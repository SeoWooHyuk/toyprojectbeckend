package com.springboot.beckend.comment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentResponse {
    private Integer updatecheck;

    public UpdateCommentResponse(Integer updatecheck) {
        this.updatecheck = updatecheck;
    }

}
