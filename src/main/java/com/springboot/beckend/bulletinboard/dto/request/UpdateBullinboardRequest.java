package com.springboot.beckend.bulletinboard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBullinboardRequest {

    private Integer seq; //게시판 번호
    private String title; //게시글 제목
    private String content; //게시글 내용
    private String files;  //첨부파일 이름
}
