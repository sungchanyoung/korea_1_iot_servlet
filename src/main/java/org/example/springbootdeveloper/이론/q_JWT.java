package org.example.springbootdeveloper.이론;

public class q_JWT {
    /*
    JSON 객체를 이용하여 사용자의 인증 정보를 안전하게 전달하는 토큰 기반 인증 방식
    서버>> 클라이언트에게 발급하는 디지털 서명이 된 토큰
    사용자의 인증 상태를 우지하며 서버에 전달
    Stateless 방식으로 서버에서 세션을 우지할 필요 X 무상태성

    JWT의 특징
    -인증 :(Authentication)
    :사용자가 로그인 하면 서버는 사용자 정보를 기반으로 JWT를  발급
    : 이후 사용자가 토큰을 서버에 전달하며 인증을 진행

    -인가(Authorization)
    :JWT에는 사용자권한 정보가  담길 수 있음
    : API 또는 라소스에 대한 접근 권한을 부여

    Stateless
    : 서버가 세션을 저장할 필요 X  , 클라이언트가 관리하기 때문에 확장성이 뛰어남

    3.발급 받은 JWT를 이용한 인증 방법
    :HTTP요청 헤더 중에 Authorization 키값에 "Beaer"+ JWT토큰값을 전달

    4.JWT의 구조
    .(마침표)를 기준으로 헤더(header),내용(content),서명(signature)으로 이루어짐
    1)헤더
    토큰 타입과 해싱 알고리즘정보를 포함

    2) 내용
    :사용자 정보권한 같은 클레임을 포함
    Base64로 인코딩 됨 ,암호화되지 않기 때문에 중요한 정보 저장X

    서명
    header
     */
}
