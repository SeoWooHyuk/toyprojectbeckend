package com.springboot.beckend.bulletinboard.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBullinboardResponse {
    
    private Integer seq; //게시판 번호

    public CreateBullinboardResponse(Integer seq) {
        this.seq = seq;
    }

  

    
      
}
