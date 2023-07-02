package com.springboot.beckend.comment.dto.response;

import java.util.List;
import com.springboot.beckend.comment.domain.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentListResponse {

    private List<Comment> CommentList;
    private Integer pageCnt;


     public CommentListResponse(List<Comment> CommentList,Integer pageCnt) {
        this.CommentList = CommentList;
        this.pageCnt = pageCnt;
    }

}
