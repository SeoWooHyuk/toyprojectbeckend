package com.springboot.beckend.bulletinboard.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beckend.bulletinboard.dao.BulletinboardDao;
import com.springboot.beckend.bulletinboard.domain.Bulletinboard;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListParam;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListReplyParam;
import com.springboot.beckend.bulletinboard.dto.param.CountParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardReplyParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateReadCountPram;
import com.springboot.beckend.bulletinboard.dto.param.UpdateBullinboardParam;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListReplyRequest;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardReplyRequest;
import com.springboot.beckend.bulletinboard.dto.request.CreateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.request.UpdateBullinboardRequest;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardListReplyResponse;
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

        List<Bulletinboard> bsList = dao.getBulSearchboardList(param);

        Integer pageCnt = dao.getBulCountboard(countparam);

        System.out.println(bsList.size());

        // for (Bulletinboard item : bsList) {
        //     System.out.println(item);
        // }

        return new BulletinboardListResponse(bsList, pageCnt);
	
	}

    //게시글 상세
     public BulletinboardResponse getbulletinboard(Integer seq, String readerId)
     {

        System.out.println("게시글상세 아이디"+readerId);
        System.out.println("게시글 번호"+seq);
        CreateReadCountPram param = new CreateReadCountPram(seq, readerId);
        System.out.println(param.getReaderId());
        System.out.println(param.getSeq());


        Integer check =  dao.createBulBoardReadCountHistory(param); //sql 문으로 ON DUPLICATE KEY pk값이 사용하여 중복되지않는값은 인설트되어 1출력 중복이되는 키값이있으면 업데이트되어 2출력
        System.out.println(check + "2가니오면 중복임");
        if(check == 1) //1이 여지만 중복되는 키값이 없다는 뜻으로 조회수를 증가시킨다.
        {
            System.out.println("조회수 증가되는거?");
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

    //게시글 댓글 생성
    public CreateBullinboardResponse createBulBoardReply(Integer seq, CreateBullinboardReplyRequest req)
    {
        CreateBullinboardReplyParam param = new CreateBullinboardReplyParam(seq, req);
        dao.createBulBoardReply(param);
        return new CreateBullinboardResponse(param.getSeq());
    }


    //게시글 댓글 출력
    public BulletinboardListReplyResponse getBulBoardReplyList(Integer seq, BulletinboardListReplyRequest req)
    {
        BulletinboardListReplyParam param = new BulletinboardListReplyParam(req);
        param.setPageParam(req.getPage(),10);

        System.out.println(param.getPageStart() + "페이징 스타트");

        List<Bulletinboard> bsreplyList = dao.getBulBoardReplyList(seq,param);

        return new BulletinboardListReplyResponse(bsreplyList, bsreplyList.size());
    }





    //게시글 댓글에 댓글달기
    // public CreateBullinboardResponse createBulBoardReply2(Integer parentseq, CreateBullinboardReplyRequest req)
    // {
    //     Integer stepcount =  dao.updateBulBoardReplyStep(parentseq);
    //     Integer replycount = dao.getBulBoardReplyCount(parentseq);

    //     System.out.println(stepcount);
    //     System.out.println(replycount);

    //     	// TODO - 예외처리
	// 	if (!Objects.equals(stepcount, replycount)) {
	// 		System.out.println("BbsService createBbsAnswer: Fail update parent bbs step !!");
	// 		return null;
	// 	}

    //     CreateBullinboardReplyParam param = new CreateBullinboardReplyParam(parentseq, req);
    //     dao.createBulBoardReply(param);
    //     return new CreateBullinboardResponse(param.getSeq());
    // }
    



    
}
