package com.springboot.beckend.comment.controller;

import java.util.Date;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.beckend.comment.dto.request.CommentRequest;
import com.springboot.beckend.comment.dto.request.CreateCommentRequest;
import com.springboot.beckend.comment.dto.request.UpdateCommentRequest;
import com.springboot.beckend.comment.dto.response.CommentListResponse;
import com.springboot.beckend.comment.dto.response.CreateCommentResponse;
import com.springboot.beckend.comment.dto.response.DeleteCommentResponse;
import com.springboot.beckend.comment.dto.response.UpdateCommentResponse;
import com.springboot.beckend.comment.service.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    public CommentController(CommentService service) {
        this.service = service;
    }

    //게시글 댓글출력
    @GetMapping
    public ResponseEntity<CommentListResponse> getBulCommentList(@ModelAttribute CommentRequest req)
    {
           System.out.println("CommentController getBulCommentList() " + new Date());
           return ResponseEntity.ok(service.getCommentList(req));
    }
   
    //게시글댓글 생성
    @PostMapping
    public ResponseEntity<CreateCommentResponse> createComment(@RequestParam Integer bulSeq, 
    @RequestBody CreateCommentRequest req)
    {
        System.out.println("CommentController createComment() " + new Date());
        return ResponseEntity.ok(service.createComment(bulSeq,req));
    }

    //게시글 댓글 삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity<DeleteCommentResponse> deleteComment(@PathVariable Integer seq)
    {
        System.out.println("CommentController deleteComment() " + new Date());
        return ResponseEntity.ok(service.deleteComment(seq));
    }


    //게시글 댓글 수정
    @PutMapping("/{seq}")
    public ResponseEntity<UpdateCommentResponse> updateComment(@PathVariable Integer seq, @RequestBody UpdateCommentRequest req)
    {
        System.out.println("CommentController updateComment() " + new Date());
        System.out.println(req.getContent());
        return ResponseEntity.ok(service.updateComment(seq,req));
    }




}
