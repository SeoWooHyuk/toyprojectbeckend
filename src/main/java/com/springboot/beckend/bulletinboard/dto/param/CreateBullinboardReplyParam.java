package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardReplyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBullinboardReplyParam {

    private Integer replynum;
    private Integer seq;
    private String id;
    private String title;
    private String content;
    
    public CreateBullinboardReplyParam(Integer seq,CreateBullinboardReplyRequest req) {
        this.seq = replynum;
        this.seq = seq;
        this.id = req.getId();
        this.content = req.getContent();
    }


    
}
