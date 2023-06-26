package com.springboot.beckend.member.dao;


import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.springboot.beckend.member.domain.InfoMember;
import com.springboot.beckend.member.dto.param.CreateInfoMemberParam;



@Mapper
@Repository
public interface InfoMemberDao {
    

	public InfoMember findById(String id);

	public Integer isExistUserId(String id);

	public Integer createMember(CreateInfoMemberParam param);


}
