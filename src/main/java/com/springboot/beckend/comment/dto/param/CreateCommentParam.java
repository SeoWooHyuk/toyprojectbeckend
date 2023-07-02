package com.springboot.beckend.comment.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardReplyRequest;
import com.springboot.beckend.comment.dto.request.CreateCommentRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentParam {

    private Integer seq;
    private Integer bulSeq;
    private String id;
    private String content;
    
    public CreateCommentParam(Integer bulSeq, CreateCommentRequest req) {
        this.bulSeq = bulSeq;
        this.id = req.getId();
        this.content = req.getContent();
    }


    
}
