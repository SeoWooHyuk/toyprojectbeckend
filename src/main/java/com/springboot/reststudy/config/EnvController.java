package com.springboot.reststudy.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EnvController {
	
	String envValue;
	
	@GetMapping("/getEnvValue")
	public ResponseEntity<Object> getEnvValue() {
		return new ResponseEntity<Object>(envValue, HttpStatus.OK);
	}
}