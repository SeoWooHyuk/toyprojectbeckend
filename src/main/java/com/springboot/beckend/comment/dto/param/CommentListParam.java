package com.springboot.beckend.comment.dto.param;

import com.springboot.beckend.comment.dto.request.CommentRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentListParam extends PageParam{
    
    private Integer bulSeq; // 게시글 번호
    private Integer page;

    public CommentListParam(CommentRequest req) {

        this.bulSeq = req.getBulSeq();
        this.page = req.getPage();
    }

     
}
