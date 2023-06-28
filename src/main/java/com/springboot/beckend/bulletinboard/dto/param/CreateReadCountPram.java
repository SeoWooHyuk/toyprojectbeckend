package com.springboot.beckend.bulletinboard.dto.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReadCountPram {

     private Integer seq; //게시글 번호
     private String readerId; // 게시글 조회자 아이디


    public CreateReadCountPram(Integer seq, String readerId) {
        this.seq = seq;
        this.readerId = readerId;
    }

}
