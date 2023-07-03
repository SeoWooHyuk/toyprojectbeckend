package com.springboot.beckend.member.controller;

import java.util.Date;
import jakarta.validation.Valid;

import org.json.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.beckend.member.dto.request.JoinRequest;
import com.springboot.beckend.member.dto.request.LoginRequest;
import com.springboot.beckend.member.dto.response.JoinResponse;
import com.springboot.beckend.member.dto.response.LoginResponse;
import com.springboot.beckend.member.exception.InfoMemberException;
import com.springboot.beckend.member.service.InfoMemberService;
import io.swagger.v3.oas.annotations.tags.Tag;


@RestController
@RequestMapping("/user")
@Tag(name = "InfoMemberController", description = "회원정보")
public class InfoMemberController {

	private final InfoMemberService service;

	public InfoMemberController(InfoMemberService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<?> checkIdDuplicate(@RequestParam String id) {
		System.out.println("UserController checkIdDuplicate " + new Date());

		HttpStatus status = service.checkIdDuplicate(id);
		return new ResponseEntity<>(status);
	}

	@PostMapping("/join")
	public ResponseEntity<JoinResponse> join(@Valid @RequestBody JoinRequest req) {
		System.out.println(req.getCheckPwd());
		System.out.println("UserController join " + new Date());

		return ResponseEntity.ok(service.join(req));

	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest req) {
		System.out.println("UserController login " + new Date());
		return ResponseEntity.ok(service.login(req));
	}


	/* 요청 DTO 검증 예외처리 핸들러 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		System.out.println("UserController handleMethodArgumentNotValidException " + new Date());

		BindingResult bs = e.getBindingResult();
		//회원가입에있는 @Valid 어노테이션을 사용한 유효성 검증이 실패하면, MethodArgumentNotValidException 예외가 발생할 때 함께 생성되어 반환
		StringBuilder sb = new StringBuilder(); //tringBuilder 클래스는 문자열 연결 시 발생하는 성능 이슈를 해결하기 위해 제공되는 클래스

		//BindingResult 인터페이스의 getFieldErrors() 메소드는 검증한 필드의 에러 목록을 가져오는 역할
		bs.getFieldErrors().forEach(err -> {
			sb.append(String.format("[%s]: %s.\n입력된 값: %s",
						err.getField(), err.getDefaultMessage(), err.getRejectedValue()));
		});

		// Map 으로 보낸다면 프론트에서 사용하기 더 편리할 듯 !
		return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
		//HTTP 상태코드 400(Bad Request)를 응답
	}

	/* 사용자 관련 요청 예외처리 핸들러 */
	@ExceptionHandler(InfoMemberException.class)
	//메소드에서 발생한 예외를 자동으로 캐치해서 처리
	public ResponseEntity<?> handleUserException(InfoMemberException e) {
		System.out.println("UserController handlerUserException " + new Date());

		return new ResponseEntity<>(e.getMessage(), e.getStatus());
	}
}


