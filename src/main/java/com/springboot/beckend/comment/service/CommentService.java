package com.springboot.beckend.comment.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.beckend.comment.dao.CommentDao;
import com.springboot.beckend.comment.domain.Comment;
import com.springboot.beckend.comment.dto.param.CommentListParam;
import com.springboot.beckend.comment.dto.param.CreateCommentParam;
import com.springboot.beckend.comment.dto.param.UpdateCommentParam;
import com.springboot.beckend.comment.dto.request.CommentRequest;
import com.springboot.beckend.comment.dto.request.CreateCommentRequest;
import com.springboot.beckend.comment.dto.request.UpdateCommentRequest;
import com.springboot.beckend.comment.dto.response.CommentListResponse;
import com.springboot.beckend.comment.dto.response.CreateCommentResponse;
import com.springboot.beckend.comment.dto.response.DeleteCommentResponse;
import com.springboot.beckend.comment.dto.response.UpdateCommentResponse;


@Service
@Transactional
public class CommentService {

    private final CommentDao dao;

    public CommentService(CommentDao dao) {
        this.dao = dao;
    }

    //게시글 댓글 출력
    public CommentListResponse getCommentList(CommentRequest req)
    {
        CommentListParam param = new CommentListParam(req);
        param.setPageParam(req.getPage(),10);
        Integer commentcount =   dao.getCommentCount(req.getBulSeq());
        List<Comment> commentList = dao.getCommentList(param);
        return new CommentListResponse(commentList, commentcount);
    }

    //게시글 댓글 생성
    public CreateCommentResponse createComment(Integer bulSeq, CreateCommentRequest req)
    {
        CreateCommentParam param = new CreateCommentParam(bulSeq, req);
        dao.createComment(param);
        return new CreateCommentResponse(param.getSeq());
    }


    //댓글 삭제
    public DeleteCommentResponse deleteComment(Integer seq) {
        Integer deletedcheck = dao.deleteComment(seq);
        return new DeleteCommentResponse(deletedcheck);
    }

    //댓글 수정
    public UpdateCommentResponse updateComment(Integer seq, UpdateCommentRequest req) {    
        Integer updatecheck = dao.updateComment(new UpdateCommentParam(seq, req));
        return new UpdateCommentResponse(updatecheck);
    }
   
}
