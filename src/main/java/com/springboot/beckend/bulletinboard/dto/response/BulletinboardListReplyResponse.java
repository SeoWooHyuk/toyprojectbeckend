package com.springboot.beckend.bulletinboard.dto.response;

import java.util.List;

import com.springboot.beckend.bulletinboard.domain.Bulletinboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinboardListReplyResponse {
    private List<Bulletinboard> bsReplyList;


     public BulletinboardListReplyResponse(List<Bulletinboard> bsReplyList) {
        this.bsReplyList = bsReplyList;
    }

}
