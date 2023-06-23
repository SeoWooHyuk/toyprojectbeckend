package com.springboot.reststudy.member.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.springboot.reststudy.member.domain.InfoMember;
import com.springboot.reststudy.member.dto.param.CreateInfoMemberParam;



@Mapper
@Repository
public interface InfoMemberDao {
    

	InfoMember findById(String id);

	Integer isExistUserId(String id);

	Integer createMember(CreateInfoMemberParam param);


}
