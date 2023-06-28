package com.springboot.beckend.bulletinboard.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beckend.bulletinboard.dao.BulletinboardDao;
import com.springboot.beckend.bulletinboard.domain.Bulletinboard;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListParam;
import com.springboot.beckend.bulletinboard.dto.param.CountParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardReplyParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateReadCountPram;
import com.springboot.beckend.bulletinboard.dto.param.UpdateBullinboardParam;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardReplyRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.request.UpdateBullinboardRequest;
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
     public BulletinboardResponse getbulletinboard(Integer seq, String readerId)
     {
        CreateReadCountPram param = new CreateReadCountPram(seq, readerId);
        System.out.println(readerId);


        Integer check =  dao.createBulBoardReadCountHistory(param); //sql 문으로 ON DUPLICATE KEY pk값이 사용하여 중복되지않는값은 인설트되어 1출력 중복이되는 키값이있으면 업데이트되어 2출력
        System.out.println(check);
        if(check == 1) //1이 여지만 중복되는 키값이 없다는 뜻으로 조회수를 증가시킨다.
        {
            dao.increaseBulBoardReadCount(seq);
        }
        return new BulletinboardResponse(dao.getbulletinboard(seq));
     }

    //게시글 생성
    public CreateBullinboardResponse createBulBoard(CreateBullinboardRequest req)
    {
        CreateBullinboardParam param = new CreateBullinboardParam(req);
        dao.createBulBoard(param);
        return new CreateBullinboardResponse(param.getSeq());
    }
    
    //게시글 수정
    public UpdateBullinboardResponse updateBulBoard(Integer seq, UpdateBullinboardRequest req)
    {
        UpdateBullinboardParam param = new UpdateBullinboardParam(seq,req);
        dao.updateBulBoard(param);
       return new UpdateBullinboardResponse(param.getSeq());
    } 

    
    //게시글 삭제
    public DeleteBullinboardResponse deleteBulBoard(Integer seq)
    {
        Integer deletecheck = dao.deleteBulBoard(seq);
        return new DeleteBullinboardResponse(deletecheck);
    }

    //게시글 댓글달기
    public CreateBullinboardResponse createBulBoardReply(Integer parentseq, CreateBullinboardReplyRequest req)
    {
        CreateBullinboardReplyParam param = new CreateBullinboardReplyParam(parentseq, req);
        dao.createBulBoardReply(param);
        return new CreateBullinboardResponse(param.getSeq());
    }
    



    
}
