package org.example.springbootdeveloper.이론;

public class h_dispathchServlet {
    //DS(dispatchServlet)
    //스프링 부트의 핵심 서블릿
    // 클라이언트의 요청을 받아 알맞은 핸들로 (Controller)를 찾아 실행하고
    //, 처리된 결과를 다시 클라이언트에게 반환
    //httpServletRequest/HttpServletRespone
    //:웹 애플리케이션의 요청 흐름을 관리하는 중심 역활
    // == dispatchServlet
    // 1클라이언트 요청 처리
    // 사용자가 웹에서 요청 get,post ,put,delete 을 보냄
    // 서블릿 컨테이너 DS로 요청을 전달

    // Handler (controller)조회
   // handlerMapping을 통해 요청 URI에 맞는 핸들러를 찾음
   //EX))/student로 요청  -> StudentController가 매핑

    //3) Handler adapter 조회
    // 매핑한 핸들러 실행 을 위한 어댑터 찾고
    // controller가 실행될 수 있는 형태로 어댑터가 변환
    //handler adepter찾은 핸들러를 실행
    /*
    핸들러가 요청 처리하고 결과를 어댑터로 반환

    5
    @Restcontroller  사용시
   view와 viewResolver 를 거치지 않음
   messageconverter  총해 json형식으로 변환
     */
}
