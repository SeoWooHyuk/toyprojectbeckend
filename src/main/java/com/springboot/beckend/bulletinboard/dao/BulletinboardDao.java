package com.springboot.beckend.bulletinboard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.springboot.beckend.bulletinboard.domain.Bulletinboard;
import com.springboot.beckend.bulletinboard.dto.param.BulletinboardListParam;
import com.springboot.beckend.bulletinboard.dto.param.CountParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateBullinboardParam;
import com.springboot.beckend.bulletinboard.dto.param.CreateReadCountPram;
import com.springboot.beckend.bulletinboard.dto.param.UpdateBullinboardParam;

@Mapper
@Repository
public interface BulletinboardDao {

    //전체 리스트 출력
    public List<Bulletinboard> getBulSearchboardList(BulletinboardListParam  param);
    
    //전체게시글 페이징용 검색시 카운트
    public Integer getBulCountboard(CountParam param);

    //게시글 상세페이지 출력
    public Bulletinboard getbulletinboard(Integer seq);

    //게시글 조회수 증가 카운트 
    public Integer increaseBulBoardReadCount(Integer seq);

    //게시글 접속자 접속시간확인 조회시 레코드저장 아이디값이 같은게 중복될시 그아이디값의 열은 지금날짜로 수정해라 
    Integer createBulBoardReadCountHistory(CreateReadCountPram param);

    //게시판 생성
    public void createBulBoard(CreateBullinboardParam param);

    //게시글 삭제 필드에 1이면 나중에 스케쥴러사용 지정한 시간대에 일괄삭제 한다.
    public Integer deleteBulBoard(Integer seq);

    //게시글 수정
    public Integer updateBulBoard(UpdateBullinboardParam param);




    
    // //게시글 답글 생성
    // public void createBulBoardReply(CreateBullinboardReplyParam param);

    // //게시글 댓글 출력
    // public List<Bulletinboard> getBulBoardReplyList(@Param("seq")Integer seq , @Param("param")BulletinboardListReplyParam param);

    // //게시글 댓글 페이징용 카운트
    // public Integer getBulReplyCountboard(Integer seq);

    // public Integer updateBulBoardReplyStep(Integer parentSeq);
	// public Integer getBulBoardReplyCount(Integer parentSeq);




     



}
