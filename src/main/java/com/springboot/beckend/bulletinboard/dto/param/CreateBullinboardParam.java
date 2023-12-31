package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateBullinboardParam {
    
    private Integer seq; //게시판 번호
    private String id;  //아이디 pk값
    private String title; //게시글 제목
    private String content; //게시글 내용
    private String files;  //첨부파일 이름


    public CreateBullinboardParam(CreateBullinboardRequest req) {
        this.id = req.getId();
        this.title = req.getTitle();
        this.content = req.getContent();
        this.files = req.getFiles();
    }


}
