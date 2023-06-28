package com.springboot.beckend.bulletinboard.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beckend.bulletinboard.dao.BulletinboardDao;
import com.springboot.beckend.bulletinboard.domain.Bulletinboard;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListParam;
import com.springboot.beckend.bulletinboard.dto.param.CountParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardParam;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardListResponse;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardResponse;
import com.springboot.beckend.bulletinboard.dto.response.CreateBullinboardResponse;
import com.springboot.beckend.bulletinboard.dto.response.DeleteBullinboardResponse;
import com.springboot.beckend.bulletinboard.dto.response.UpdateBullinboardResponse;



@Service
@Transactional
public class BulletinboardService {

    private final BulletinboardDao dao;

    public BulletinboardService(BulletinboardDao dao) {
        this.dao = dao;
    }

    //게시글 전체출력
    public BulletinboardListResponse getBulboardList(BulletinboardListRequest req) {

    
		BulletinboardListParam param = new BulletinboardListParam(req);
        CountParam countparam = new CountParam(req);

		param.setPageParam(req.getPage(),10);

        System.out.println(param.getPageStart() + "시작페이지");
        System.out.println(param.getPageEnd() + "끝페이지");
        List<Bulletinboard> bsList = dao.getBulSearchboardList(param);

        Integer pageCnt = dao.getBulCountboard(countparam);

        System.out.println(bsList.size());

        for (Bulletinboard item : bsList) {
            System.out.println(item);
        }

        return new BulletinboardListResponse(bsList, pageCnt);
	
	}

    //게시글 상세
     public BulletinboardResponse getbulletinboard(Integer seq)
     {
      
        System.out.println("게시글 상세 "+ seq);
        return new BulletinboardResponse(dao.getbulletinboard(seq));
     }

    //게시글 생성
    public CreateBullinboardResponse createBulBoard(CreateBullinboardRequest req)
    {
        CreateBullinboardParam param = new CreateBullinboardParam(req);
        dao.createBulBoard(param);
        return new CreateBullinboardResponse(param.getSeq());
    }
    
    //  //게시글 서정
    // public UpdateBullinboardResponse updateBulBoard(CreateBullinboardRequest req)
    // {
       
    // } 

    
    //게시글 삭제
    public DeleteBullinboardResponse deleteBulBoard(Integer seq)
    {
        Integer deletecheck = dao.deleteBulBoard(seq);
        return new DeleteBullinboardResponse(deletecheck);
    }

    



    
}
