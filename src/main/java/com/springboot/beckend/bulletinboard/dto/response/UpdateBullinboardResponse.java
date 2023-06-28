package com.springboot.beckend.bulletinboard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBullinboardResponse {
    
    private Integer seq; //게시판 번호

    public UpdateBullinboardResponse(Integer seq) {
        this.seq = seq;
    }
}
