package com.kt.dto;

import java.time.LocalDate;

import com.kt.domain.Gender;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

// bean validation이라는 기능을 통해서 유효성 검사
public record UserCreateRequest(
	@NotBlank // null이거나 공백이면 안 돼
	String loginId,
	@NotBlank
	@Pattern(regexp = "^(?=.[a-z])(?=.[A-Z])(?=.\\d)(?=.[!@#$%^])[A-Za-z\\d!@#$%^]{8,}$")// 최소 8자 이상, 대문자 소문자 숫자 특수문자 포함
	String password, // 길이 및 조건이 들어갈 수 있음 -> 정규식 이용
	@NotBlank
	String name,
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,}$")
	String email,
	@NotBlank
	@Pattern(regexp = "^(0\\d{1,2})-(\\d{3,4})-(\\d{4})$")
	String mobile,
	@NotNull // enum이랑 호환이 안 되는 값은 안 들어가는데 NULL은 가능 하기 떄문에 막음
	Gender gender,
	@NotNull
	LocalDate birthday
) {
}