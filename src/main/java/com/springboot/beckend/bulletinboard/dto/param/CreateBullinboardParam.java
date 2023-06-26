package com.springboot.beckend.bulletinboard.dto.param;

import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;

public class CreateBullinboardParam {
    
    private int seq; //게시판 번호
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


    public int getSeq() {
        return seq;
    }


    public void setSeq(int seq) {
        this.seq = seq;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public String getFiles() {
        return files;
    }


    public void setFiles(String files) {
        this.files = files;
    }

    

    

}
