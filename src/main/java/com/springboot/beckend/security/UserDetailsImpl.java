package com.springboot.beckend.security;
import java.util.Collection;
import java.util.Collections;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.beckend.member.domain.InfoMember;

public class UserDetailsImpl implements UserDetails {

    private final InfoMember infoMember;

    public UserDetailsImpl(InfoMember infoMember) {
        this.infoMember = infoMember;
    }

    public InfoMember getMember() {
        return infoMember;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override
    public String getPassword() {
        return infoMember.getPwd();
    }

    @Override
    public String getUsername() {
        return infoMember.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
