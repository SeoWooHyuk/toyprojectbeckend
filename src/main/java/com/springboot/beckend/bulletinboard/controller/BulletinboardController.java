package com.springboot.beckend.bulletinboard.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardReplyRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.request.UpdateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardListResponse;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardResponse;
import com.springboot.beckend.bulletinboard.dto.response.CreateBullinboardResponse;
import com.springboot.beckend.bulletinboard.dto.response.DeleteBullinboardResponse;
import com.springboot.beckend.bulletinboard.dto.response.UpdateBullinboardResponse;
import com.springboot.beckend.bulletinboard.service.BulletinboardService;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/bulletinboard")
@Tag(name = "BulletinboardController", description = "게시판")
public class BulletinboardController {
    
     private final BulletinboardService service;

    public BulletinboardController(BulletinboardService service) {
        this.service = service;
    }

    //전체게시글조회
   	@GetMapping
    public ResponseEntity<BulletinboardListResponse> getbulboardList(@ModelAttribute BulletinboardListRequest req)
    {
        System.out.println("BulletinboardController getbulboardList() " + new Date());
        return ResponseEntity.ok(service.getBulboardList(req));
    }

    //상세게시글조회
   	@GetMapping("/{seq}")
    public ResponseEntity<BulletinboardResponse> getbulletinboard(@PathVariable Integer seq)
    {
        System.out.println(seq);
        System.out.println("BulletinboardController getbulboard() " + new Date());
        return ResponseEntity.ok(service.getbulletinboard(seq));
    }


    //게시글 생성
    @PostMapping
    public ResponseEntity<CreateBullinboardResponse> createBulBoard(@RequestBody CreateBullinboardRequest req)
    {
        System.out.println("BulletinboardController CreateBulBoard() " + new Date());

        return ResponseEntity.ok(service.createBulBoard(req));
    }

    //게시글 수정
    @PutMapping("/{seq}")
    public ResponseEntity<UpdateBullinboardResponse> updataeBulBoard(@PathVariable Integer seq , @RequestBody UpdateBullinboardRequest req)
    {
        System.out.println("BulletinboardController updataeBulBoard() " + new Date());

        return ResponseEntity.ok(service.updateBulBoard(seq,req));
    }

    //게시글삭제
    @DeleteMapping("/{seq}")
    public ResponseEntity<DeleteBullinboardResponse> deleteBulBoard(@PathVariable Integer seq)
    {
           System.out.println("BulletinboardController deleteBulBoard() " + new Date());
           
           return ResponseEntity.ok(service.deleteBulBoard(seq));
    }

    //게시글답글
    @PostMapping("/{parentseq}/reply")
    public ResponseEntity<CreateBullinboardResponse> createBulBoardReply(@PathVariable Integer parentseq, @RequestBody CreateBullinboardReplyRequest req)
    {
           System.out.println("BulletinboardController createBulBoardReply() " + new Date());
           return ResponseEntity.ok(service.createBulBoardReply(parentseq,req));
    }

    
   
}
