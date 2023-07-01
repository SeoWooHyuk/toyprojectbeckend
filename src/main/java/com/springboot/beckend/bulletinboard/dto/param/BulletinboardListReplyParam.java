package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListReplyRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinboardListReplyParam extends PageParam{
     private Integer page;
    private Integer seq;

    public BulletinboardListReplyParam(Integer seq , BulletinboardListReplyRequest req) {

        this.page = req.getPage();
        this.seq = seq;
    }

     
}
