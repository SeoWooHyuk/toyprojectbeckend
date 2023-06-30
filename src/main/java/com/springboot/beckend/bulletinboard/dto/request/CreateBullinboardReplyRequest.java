package com.springboot.beckend.bulletinboard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBullinboardReplyRequest {

    private String id;
    private String content;
}
