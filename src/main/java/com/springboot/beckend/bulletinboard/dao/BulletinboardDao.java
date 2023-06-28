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

    //게시글 상세페이지 출력
    public Bulletinboard getbulletinboard(Integer seq);

    //게시판 생성
    public void createBulBoard(CreateBullinboardParam param);

    //게시글 삭제 필드에 1이면 나중에 스케쥴러사용 지정한 시간대에 일괄삭제 한다.
    Integer deleteBulBoard(Integer seq);


    Integer updateBulBoard(Integer seq);


     



}
