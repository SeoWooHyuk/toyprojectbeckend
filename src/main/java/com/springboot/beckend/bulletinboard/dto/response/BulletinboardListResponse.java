package com.springboot.beckend.bulletinboard.dto.response;

import java.util.List;

import com.springboot.beckend.bulletinboard.domain.Bulletinboard;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinboardListResponse {

    private List<Bulletinboard> bsList;
    private Integer pageCnt;

    public BulletinboardListResponse(List<Bulletinboard> bsList, Integer pageCnt) {
        this.bsList = bsList;
        this.pageCnt = pageCnt;
    }

}
