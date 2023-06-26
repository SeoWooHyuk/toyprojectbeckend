package com.springboot.beckend.bulletinboard.dto.response;

import java.util.List;

import com.springboot.beckend.bulletinboard.domain.Bulletinboard;

public class BulletinboardListResponse {

    private List<Bulletinboard> bsList;
    private Integer pageCnt;

    public BulletinboardListResponse(List<Bulletinboard> bsList, Integer pageCnt) {
        this.bsList = bsList;
        this.pageCnt = pageCnt;
    }

    public List<Bulletinboard> getBsList() {
        return bsList;
    }

    public void setBsList(List<Bulletinboard> bsList) {
        this.bsList = bsList;
    }

    public Integer getPageCnt() {
        return pageCnt;
    }

    public void setPageCnt(Integer pageCnt) {
        this.pageCnt = pageCnt;
    }
    

}
