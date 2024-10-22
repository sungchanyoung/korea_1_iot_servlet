package org.example.springbootdeveloper.service;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.UserLoginRequestDto;
import org.example.springbootdeveloper.dto.request.UserRequestDto;
import org.example.springbootdeveloper.dto.response.UserLoginResponseDto;
import org.example.springbootdeveloper.entity.User;
import org.example.springbootdeveloper.provider.JwtProvider;
import org.example.springbootdeveloper.repository.UserRepository;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService  {
    // 비즈니스 로직
    // Controller의 요청을 받아 필요한 데이터를 Repository를 통해 얻거나 전달하고
    // , 기능 구현 후 응답을 Controller에게 전달

    // +) 기능 구현에 있어 필요한 보안을 설정

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    public UserService(UserRepository userRepository,@Lazy AuthenticationManager authenticationManager
    ,BCryptPasswordEncoder bCryptPasswordEncode,JwtProvider jwtProvider
                       ){
        this.bCryptPasswordEncoder =bCryptPasswordEncode;
        this.userRepository = userRepository;
        this.authenticationManager =authenticationManager;
        this.jwtProvider = jwtProvider;
    }

    // 회원 가입
    public String signup(UserRequestDto dto) {
        try {
            // 중복되는 이메일 검증
            if (userRepository.existsByEmail(dto.getEmail())) {
                throw new RuntimeException("Email already exists");
            }

            // 패스워드 암호화
            String encodedPassword = bCryptPasswordEncoder.encode(dto.getPassword());

            User user = User.builder()
                    .email(dto.getEmail())
                    .password(encodedPassword)
                    .build();

            userRepository.save(user);
            return "회원가입이 성공적으로 완료되었습니다.";

        } catch (Exception e) {
            return "회원가입에 실패하였습니다: " + e.getMessage();
        }
    }
    //사용자 인증 처리
    public UserLoginResponseDto login(UserLoginRequestDto dto) {
     // 해당 이메일의 유저가 있는지 검색하고 있을겨우 해당 데이터 반환
       try {
           User user = userRepository.findByEmail(dto.getEmail())
                   .orElseThrow(()-> new RuntimeException("User not found"));
           if(!bCryptPasswordEncoder.matches(dto.getPassword(), user.getPassword())){
               throw  new RuntimeException("Invalid password");
           }
//           Authentication authentication =authenticationManager.authenticate(
//                   new UsernamePasswordAuthenticationToken(
//                           dto.getEmail(),
//                           dto.getPassword()
//                   )
//           );
           //인증 성공후 JWT토큰 생성
           String token = jwtProvider.generateJwtToken(dto.getEmail());
           return  new UserLoginResponseDto(token);

       } catch (Exception e) {
          return null;
       }
    }



}
