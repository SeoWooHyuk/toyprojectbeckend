package com.springboot.beckend.bulletinboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.springboot.beckend.bulletinboard.domain.Bulletinboard;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListParam;
import com.springboot.beckend.bulletinboard.dto.param.CountParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardParam;

@Mapper
@Repository
public interface BulletinboardDao {

    //전체 리스트 출력
    public List<Bulletinboard> getBulSearchboardList(BulletinboardListParam  param);
    public Integer getBulCountboard(CountParam param);

    //게시판 생성
    public void CreateBulBoard(CreateBullinboardParam param);



}
