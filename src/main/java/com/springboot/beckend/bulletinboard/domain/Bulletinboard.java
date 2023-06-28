package com.springboot.beckend.bulletinboard.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Bulletinboard {

    private int seq; //게시판 번호
    private String id;  //아이디 pk값
    private int ref; //글의 그룹 번호 (같은 그룹에 속한 글들은 같은 ref 값을 가짐)
	private int step; //같은 그룹 내에서의 순서 번호 (오름차순으로 정해짐)
	private int depth; //답글의 단계. 원글일 경우 0, 답글의 경우 그에 따른 단계 (보통 1부터 시작함)
    private String title; //게시글 제목
    private String content; //게시글 내용
    private String createdAt; // 작성일
    private int del; //글 삭제 여부 (1이면 삭제, 0이면 삭제되지 않음)
	private int readCount; // 조회수
    private String files;  //첨부파일 이름

    public Bulletinboard(){
    };

    public Bulletinboard(int seq, String id, int ref, int step, int depth, String title, String content,
            String createdAt, int del, int readCount, String files) {
        super();        
        this.seq = seq;
        this.id = id;
        this.ref = ref;
        this.step = step;
        this.depth = depth;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.del = del;
        this.readCount = readCount;
        this.files = files;
    }

    public Bulletinboard(String id, String title, String content, String files) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.files = files;
    }

   
    @Override
	public String toString() {
		return "BulletinboardDto [seq=" + seq + ", id=" + id + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", title="
				+ title + ", content=" + content + ", createdAt=" + createdAt + ", del=" + del + ", readCount=" + readCount + ", files=" + files 
				+  "]";
	}

  
    

    
    

    
}

