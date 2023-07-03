package com.springboot.beckend.member.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.springboot.beckend.member.domain.InfoMember;
import com.springboot.beckend.member.dto.param.CreateInfoMemberParam;



@Mapper
@Repository
public interface InfoMemberDao {
    

	public InfoMember findById(String id); //시큐리티 디테일서비스에서 사용 

 	public Integer isExistUserId(String id); //중복여부확인

	public Integer createMember(CreateInfoMemberParam param);  //화원가입처리


}
