package com.springboot.beckend.comment.dto.param;

import com.springboot.beckend.comment.dto.request.UpdateCommentRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateCommentParam {
    private Integer seq;
    private String content;

    public UpdateCommentParam(Integer seq, UpdateCommentRequest req) {
        this.seq = seq;
        this.content = req.getContent();
    }
}
