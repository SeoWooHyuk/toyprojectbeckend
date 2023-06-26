package com.springboot.beckend.bulletinboard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BulletinboardListRequest {
    private String choice;
    private String search;
    private Integer page;
}
