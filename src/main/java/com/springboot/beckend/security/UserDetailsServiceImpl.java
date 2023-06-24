package com.springboot.beckend.security;

import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springboot.beckend.member.dao.InfoMemberDao;
import com.springboot.beckend.member.domain.InfoMember;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final InfoMemberDao infoMemberDao;

    public UserDetailsServiceImpl(InfoMemberDao infoMemberDao) {
        this.infoMemberDao = infoMemberDao;
    }

    // username = User (id)
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("UserDetailsServiceImpl loadUserByUsername " + new Date());
        InfoMember member = infoMemberDao.findById(username);
        if (member == null) {
            throw new UsernameNotFoundException(String.format("'%s'는 존재하지 않는 사용자입니다.", username));
        }

        return new UserDetailsImpl(member);
    }
}
