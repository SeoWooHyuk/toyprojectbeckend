package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinboardListParam extends PageParam{

    private String choice;
    private String search;
    private Integer page;


    public BulletinboardListParam(BulletinboardListRequest req) {
        this.choice = req.getChoice();
        this.search = req.getSearch();
        this.page = req.getPage();
    }

}

