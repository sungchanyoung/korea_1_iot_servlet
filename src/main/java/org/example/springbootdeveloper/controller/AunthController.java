package org.example.springbootdeveloper.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.common.constant.ApiMappingPattern;
import org.example.springbootdeveloper.dto.request.UserSignInRequestDto;
import org.example.springbootdeveloper.dto.request.UserSignUpRequestDto;
import org.example.springbootdeveloper.dto.response.ResponseDto;
import org.example.springbootdeveloper.dto.response.UserLoginResponseDto;
import org.example.springbootdeveloper.dto.response.UserSignUpResponseDto;
import org.example.springbootdeveloper.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiMappingPattern.AUTH)
@RequiredArgsConstructor
public class AunthController {

    private final AuthService authService;
    private final String POST_SIGN_UP = "/signUp";
    private final String POST_SIGN_IN = "/signIn";


    //AnthController vs UserController
    //1.AuthController
//   인증(Authentication) 인가(Authorization)와 관련된
//    -모든 로직을 처리하는 커트롤러
//    -로그인 로그아웃토큰 발급등 사용자 인증과 관련된 기능을 포함
    @PostMapping(POST_SIGN_UP)
    public ResponseEntity<ResponseDto<UserSignUpResponseDto>> signup(@Valid @RequestBody UserSignUpRequestDto dto) {
        try {
            ResponseDto<UserSignUpResponseDto> result = authService.signup(dto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @PostMapping(POST_SIGN_IN)
    public ResponseEntity<ResponseDto<UserLoginResponseDto>> signIn(@Valid @RequestBody UserSignInRequestDto dto) {
        try {
            ResponseDto<UserLoginResponseDto> result = authService.signIn(dto);
            return ResponseEntity.status(HttpStatus.OK).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
