package com.springboot.beckend.bulletinboard.controller;

import java.util.Date;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardListResponse;
import com.springboot.beckend.bulletinboard.dto.response.CreateBullinboardResponse;
import com.springboot.beckend.bulletinboard.service.BulletinboardService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/bulletinboard")
@Tag(name = "BulletinboardController", description = "게시판")
public class BulletinboardController {
    
     private final BulletinboardService service;

    public BulletinboardController(BulletinboardService service) {
        this.service = service;
    }

   	@GetMapping
    public ResponseEntity<BulletinboardListResponse> getbulboardList(@ModelAttribute BulletinboardListRequest req)
    {
        System.out.println("BulletinboardController getbulboardList() " + new Date());
        return ResponseEntity.ok(service.getBulboardList(req));
    }

    @PostMapping
    public ResponseEntity<CreateBullinboardResponse> CreateBulBoard(@Valid @RequestBody CreateBullinboardRequest req)
    {
        System.out.println(req.getTitle());
        System.out.println(req.getId());
        System.out.println("BulletinboardController CreateBulBoard() " + new Date());
        // return ResponseEntity.ok(service.CreateBulBoard(req));
        return ResponseEntity.ok(null);
    }
   
}
