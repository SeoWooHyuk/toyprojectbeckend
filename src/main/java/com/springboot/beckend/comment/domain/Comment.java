package com.springboot.beckend.comment.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {

    private Integer seq; //댓글고유번호
    private Integer bulSeq; // 게시글 번호
    private String id;  //아이디 pk값
    private String content; //게시글 내용
    private String createdAt; // 작성일
    private int ref; //글의 그룹 번호 (같은 그룹에 속한 글들은 같은 ref 값을 가짐)
	private int step; //같은 그룹 내에서의 순서 번호 (오름차순으로 정해짐)
	private int depth; //답글의 단계. 원글일 경우 0, 답글의 경우 그에 따른 단계 (보통 1부터 시작함)
    private int del; //글 삭제 여부 (1이면 삭제, 0이면 삭제되지 않음)

    public Comment() {
    }

    public Comment(Integer seq, Integer bulSeq, String id, String content, String createdAt, int ref, int step,
            int depth, int del) {
        super();            
        this.seq = seq;
        this.bulSeq = bulSeq;
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.ref = ref;
        this.step = step;
        this.depth = depth;
        this.del = del;
    }



    @Override
	public String toString() {
		return "CommentDto [seq="+seq+" bulSeq=" + bulSeq + ", id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", ref=" + ref + ", step=" + step + ", depth=" + depth + ", del=" + del + "]";
	}

 

    


    

}
