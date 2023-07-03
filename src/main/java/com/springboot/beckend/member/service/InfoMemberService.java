package com.springboot.beckend.member.service;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.beckend.jwt.JwtTokenUtil;
import com.springboot.beckend.member.dao.InfoMemberDao;
import com.springboot.beckend.member.dto.param.CreateInfoMemberParam;
import com.springboot.beckend.member.dto.request.JoinRequest;
import com.springboot.beckend.member.dto.request.LoginRequest;
import com.springboot.beckend.member.dto.response.JoinResponse;
import com.springboot.beckend.member.dto.response.LoginResponse;
import com.springboot.beckend.member.exception.InfoMemberException;

import lombok.extern.slf4j.Slf4j;


@Service
@Transactional //트랜잭션관리를 위한 어노테이션
public class InfoMemberService {

	private final InfoMemberDao dao;
	private final PasswordEncoder encoder; //시큐리티에서 제공하는 비밀번호 암호화
	private final AuthenticationManager authenticationManager; //스프링 시큐리티(Spring Security)에서 사용되는 인증(authentication) 관련 관리자

	private final JwtTokenUtil jwtTokenUtil; //JWT의 토큰 생성, 토큰 검증, 토큰에서 사용자 정보 추출 등의 기능을 제공
	private final UserDetailsService userDetailsService; //시큐리티에서 인증(authentication) 작업을 수행하기 위한 인터페이스


	public InfoMemberService(InfoMemberDao dao, PasswordEncoder encoder,
		AuthenticationManager authenticationManager,
		JwtTokenUtil jwtTokenUtil,
		UserDetailsService userDetailsService) {
		this.dao = dao;
		this.encoder = encoder;
		this.authenticationManager = authenticationManager;
		this.jwtTokenUtil = jwtTokenUtil;
		this.userDetailsService = userDetailsService;
	}

	public HttpStatus checkIdDuplicate(String id) { //아이디 사용 중복 여부 확인
		isExistUserId(id);
		return HttpStatus.OK;
	}

	@Transactional
	//트랜잭션은 DBMS(Database Management System)에서 데이터의 일관성을 보장하기 위해서 제공되는 기능.
	// 데이터를 변경하는 작업을 수행하다가 오류가 발생하거나, 예외가 발생하면 이전 상태로 돌아가는 것을 보장
	public JoinResponse join(JoinRequest req) {

		saveMember(req);
		authenticate(req.getId(), req.getPwd());

		return new JoinResponse(req.getId());
	}

	private void saveMember(JoinRequest req) {
		// 아이디 중복 확인
		isExistUserId(req.getId());

		// 패스워드 일치 확인
		checkPwd(req.getPwd(), req.getCheckPwd());

		// 회원 정보 생성
		String encodedPwd = encoder.encode(req.getPwd()); //비밀번호 암호화
		CreateInfoMemberParam param = new CreateInfoMemberParam(req, encodedPwd);

		Integer result = dao.createMember(param);
		if (result == 0) {
			throw new InfoMemberException("회원 등록을 실패했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
			//서버가 클라이언트의 요청을 처리하는 과정에서 예상치 못한 오류가 발생했다는 것을 나타냄
		}
	}

	public LoginResponse login(LoginRequest req) {
		authenticate(req.getId(), req.getPwd()); 
		final UserDetails userDetails = userDetailsService.loadUserByUsername(req.getId());
		
		final String token = jwtTokenUtil.generateToken(userDetails); //db에있는 아이디가 시큐리티를 통해 인증되면 jwt토큰 생성
		return new LoginResponse(token, req.getId());
	}

	private void authenticate(String id, String pwd) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(id, pwd));
		} catch (DisabledException e) {
			throw new InfoMemberException("인증되지 않은 아이디입니다.", HttpStatus.BAD_REQUEST);
		} catch (BadCredentialsException e) {
			throw new InfoMemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void isExistUserId(String id) {
		Integer result = dao.isExistUserId(id);
		if (result == 1) {
			throw new InfoMemberException("이미 사용중인 아이디입니다.", HttpStatus.BAD_REQUEST);
		}
	}

	private void checkPwd(String pwd, String checkPwd) {
		if (!pwd.equals(checkPwd)) {
			throw new InfoMemberException("비밀번호가 일치하지 않습니다.", HttpStatus.BAD_REQUEST);
		}
	}
}




