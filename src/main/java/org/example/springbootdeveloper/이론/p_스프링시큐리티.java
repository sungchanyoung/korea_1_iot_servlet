package org.example.springbootdeveloper.이론;

public class p_스프링시큐리티 {
    /*
    스프링 시큐리티(Spring security)
    : 스프링 기반 애플리케이션보안(인증,인가,권한)을 담당하는 스프링 하위 프레임 워크
    >>다양한 애너테이션으로 CSRF공격 ,세션 고정 공격을 방어
    >> 요청 헤더 보안처리도 가능
    1.인증(Authentication auth) :
    :사용자가 누구인지 확인하는 과정  ,신원 입증 과정
    ex) 시스템이 사용자가 제시한 증거(예: 아이디,비밀번호)를 바탕으로 ,그 사용자가 주장하는 인물임을 확인

    2.인가(Authorization auth)
    :인증된 사용자가 수행할 수 있는 작업의 범위를 결정
    :사이트의 특정부분에 접근할 수 있는지 권한을 확인하는 작업

    스프링시큐리티의 구조
    필터를 기반으로 동작

    1) SecurityFilterChain :
    스프링 시큐리티의요청에 대한 보안 처리 과정에서 여러 필터를 순차적으로 적용시킴
    >> 각 필터에서 인증, 인가와 관련된 작업을 처리
    아래의 순서대로 필터를 적용시킴
    >>SecurityContextPersistenceFilter
    -LogoutFilter
    - UsernamePasswordAuthenticationFIlter
       :아이디와 패스워드가 넘어오면 인증요청을 위임하는 인증관리자 역활
       : 폼기반 로그인할 때 사용되는 필터
       : 성공시 AuthenticationSuccesshandler
       : 실패시 AuthenticationFailurehandler

    -DefaultLoginPageGeneratingFilter
    -BasicAuthenticationFilter
    -RequestCacheAwareFilter
    SecurityContextHHolderAwareRequestfilter
    -AnonymousAuthenticationFilter
    SessionManagementFilter
    -ExceptionTransLatioFilter

    *-FilterSecurityInterceptor
        :권한 부여처리를 위임,접근제어 결정을 쉽게하는 접근 결정 관리자 역할
        : 이미사용자가 인증되어 있기 떄문에 유효한 사용자인지 확인가능
        : 인가 관련 설정

    ==== 스프링 시큐리티의 절차 (인증처리) ====
     1. HTTP요청 받다옴
     : 사용자가 폼에 아이디 & 패스워드 입력 + 로그인 버튼 클릭

     2.HTTPServletRequest에 아이디와 비밀번호 정보 전달
     : AuthenticationFilter가 전달된 아이디와 비밀번호의 유효성 검사를 실시

     3.유효성검사 오나료시 실제 구현쳊인  UsernamePasswordAuthenticationToken을 만들어 전달
     : 전달받은 인증용 객체를 AuthenticationManager에게 전달

     4.UsernamePasswordAuthentucationToken을 AuthenticationProvider에 전달

     5. 사용자 아이디를 UserDetailService 전달
     :UserDetailService는사용자 아읻로 찾은 ㅏ용자 정보를 UserDetails 객체로 만들어
     :Authentication Provider에 전달

     6.DB에 있는 사용자 정보를 가져옹

     7. 입력 정보와 UserDetails정보를 비교해 실제 인증 처리를 진행

     8.인증이 완료되면 SecurityContextHolder에 Authentication을 저장
     : 인증 성공 유무에 따라 핸들러 실행
     */
}
