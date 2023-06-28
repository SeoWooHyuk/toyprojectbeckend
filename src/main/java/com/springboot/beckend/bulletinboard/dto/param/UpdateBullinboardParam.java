package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.request.UpdateBullinboardRequest;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateBullinboardParam {
    
    private Integer seq; //게시판 번호
    private String title; //게시글 제목
    private String content; //게시글 내용
    private String files;  //첨부파일 이름


    public UpdateBullinboardParam(UpdateBullinboardRequest req) {
        this.title = req.getTitle();
        this.content = req.getContent();
        this.files = req.getFiles();
    }


}
