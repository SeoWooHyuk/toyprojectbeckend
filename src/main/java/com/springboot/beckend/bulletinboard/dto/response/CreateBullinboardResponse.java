package com.springboot.beckend.bulletinboard.dto.response;

public class CreateBullinboardResponse {
    
    private int seq; //게시판 번호

    public CreateBullinboardResponse(int seq) {
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    
      
}
