package com.springboot.beckend.bulletinboard.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beckend.bulletinboard.dao.BulletinboardDao;
import com.springboot.beckend.bulletinboard.domain.Bulletinboard;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListParam;
import com.springboot.beckend.bulletinboard.dto.param.CountParam;
import com.springboot.beckend.bulletinboard.dto.request.BulletinboardListRequest;
import com.springboot.beckend.bulletinboard.dto.response.BulletinboardListResponse;



@Service
@Transactional
public class BulletinboardService {

    private final BulletinboardDao dao;

    public BulletinboardService(BulletinboardDao dao) {
        this.dao = dao;
    }

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
    
}
