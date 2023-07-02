package com.springboot.beckend.comment.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.springboot.beckend.comment.domain.Comment;
import com.springboot.beckend.comment.dto.param.CommentListParam;
import com.springboot.beckend.comment.dto.param.CreateCommentParam;
import com.springboot.beckend.comment.dto.param.UpdateCommentParam;


@Mapper
@Repository
public interface CommentDao {
    
//게시글 댓글 출력
public List<Comment> getCommentList(CommentListParam param);

//게시글 댓글 페이징용 카운트
public Integer getCommentCount(Integer bulSeq);

//게시글 답글 생성
public void createComment(CreateCommentParam param);

//게시글 댓글 삭제
public Integer deleteComment(Integer seq);

//게시글 댓글 수정
public Integer updateComment(UpdateCommentParam param);



}
