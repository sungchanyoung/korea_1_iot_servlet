package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;

import org.example.springbootdeveloper.service.UserService;
import org.springframework.context.annotation.Lazy;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController// view 사용하지 않음
@RequestMapping("/api/users")
@RequiredArgsConstructor//final ,nonNull 설정된 필드를 필수 매개변수로 하는 생성자를 만드는 애너태이션  의존성 주입
//검색 필터링 파람
public class UserController {
        // 1. 생성자 의존성 주입 방식
        // 1. 생성자 의존성 주입 방식
        private final @Lazy UserService userService;

//    public UserController(UserService userService) {
//        this.userService = userService;
//    }

    // 2. 필드 의존성 주입 방식
//    @Autowired
//    private UserService userService;

    // HTTP 메서드: POST
    // URI 경로: /signup
    // - 회원가입 로직: username, password, email

    // HTTP 메서드: POST
    // URI 경로: /login
    // - 로그인 로직: username, password

    // cf) 로그인 시 HTTP 메서드 사용

    // GET VS "POST"
    // : POST 사용을 권장
    // - 로그인 과정에서 사용자 이름과 비밀번호와 같은 민감한 데이터를 서버로 전송하기 때문
    // - GET 요청을 URL에 데이터가 노출됨

}