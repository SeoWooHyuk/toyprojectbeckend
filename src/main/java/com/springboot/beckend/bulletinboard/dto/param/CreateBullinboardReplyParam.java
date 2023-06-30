package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardReplyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBullinboardReplyParam {

    private Integer seq;
    private Integer parentSeq;
    private String id;
    private String title;
    private String content;
    
    public CreateBullinboardReplyParam(Integer seq,CreateBullinboardReplyRequest req) {
        this.seq = seq;
        this.id = req.getId();
        this.title = req.getTitle();
        this.content = req.getContent();
    }


    
}
