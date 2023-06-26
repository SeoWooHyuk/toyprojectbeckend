package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;

public class CountParam {
    private String choice;
    private String search;

     public CountParam(BulletinboardListRequest req) {
        this.choice = req.getChoice();
        this.search = req.getSearch();
        System.out.println(choice);
        System.out.println(search);
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
    
}
