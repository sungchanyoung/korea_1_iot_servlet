package org.example.springbootdeveloper.이론;

public class m_api {
    /*
    API  -Application Programming Interface
    :응용 프로그램이 서로 통신할 수 있도록 해주는 인터페이스
    :소프트웨어  간의 중재자 역활
    서로 다른 소프트웨어 시스템이 데이터를 주고받거나 기능을 호출하는 방식

     1) API 목적
     : 재사용성 -이미 작성된 기능을 여러 프로그램에서 재사용 기능
     : 유지 보수성 - 코드변경이 API에 의해 중앙에서 관리 , 다른 기능의 영향을 최소화
     :

    == API vs proxy
     HTTP -웹 환경에서 정보를 주고받기 위한 프로토콜
     : HTTP라는 통신 규칙으로 소통하는API
     :cf) 웹 개발 시 반드시 HTTP가 필요한것 은 아님

     cf) Proxy -대리서버
     : 클라이언트와 실제 서버 간의 중재자, 요청과 응답을 전달
     : IP주소 숨김 : 실제 IP주소를 숨기고 ,프록시 서버의 IP를 사용하여 서버와 통신
     - 접근 제어 :특정 웹 사이트나 데이터에 대한 접근을 차단하거나 제한


     REST API ==========
     Representional state Transfer
     :HTTP 프로토콜을 기반으로 클라이언트와 서버 간의 상호작용을 규정하는 아키텍처 스타일
     cf) 아키택처 스타일
     : 네트워크 자원을 정의하고 처리하는방법 전반

     : "자원"의 "표현"으로 "상태"를 전달하는 아키택처

     REST의 6가지 원칙
     1) 클라이언트 - 서버  구조 : 클라이언트와 서버가 명확하게 분리
     2) 무상태성 : 서버는 클라이언트 의 상태 저장 X , 요청은 독립적으러 처리
     3) 캐시 가능성 : 응답은 캐시될 수 있어야 함
     4) 계층화 시스템 : 클라이언트 여러 계층의 중개 서버와 통신 가능
     5) 일관된 인터페이스 :API가 일관된 방식으로 설계 되어야함
     6) 코드온 디멘그  -선택적

     REST api 설계 구성
     -URI로 자원을 표현

     URI가 URL을 포함
     URI는 통합 자원 식별자로  주서에 식별자가 있으면 URI
     URL은 리소스의 주소를 나타냄

     자원 : URI로 자원을 표현
     행위 : 자원에 대한 행위는 HTTP Method로 표현
     표현 : 응답 자원의 상태를 JSON, XML등의 형태로 표현

     =======RESTful API===========
     URI로 자원을 표현하는데 집중하고 ,저원의 상태(행위)에 대한 정의는
     ,HTTP Method로 하는 것이 REST하게 API를 설계 하는 규칙
     -자원에 대한 행위는 HTTP Method(GET,POST,PUT, DELETE)로 표현

     1)REST API 사용방법
     1.URL에는 동사를 쓰지 않고 자원을 표시
     EX) 상품 리소스에서 상품코드가 1004인 상품정보를 가져오는 URL
     : /Product/1004(0)
     : /get-product? product_id=1004(X)

     createProduct(동사) vs createdProduct(명사)
     2.동사는 HTTP메서드 사용
     Post 만들고  -create
     GET 일고  -READ
     PUT 업데이트 - UPDATE
     DELETE 삭제하고  - DELETE

     PUT VS PATCH
     1 PUT:전체 리소스 수정 , 전체를 대체하는 방식으로 동작
     : 기존 리소스 전체를 새로운 값으로 덮어쓰는 개념
     리소스일부만 제공 제공하지 않은 정보는 NULL 또는 기본값으로 설정
     멱등성 을 가짐  - Idempotent
         - 여러번 결과를 보내도 결과가 동일한 경우
         - 연산을 여러번 적용하더라도 결과가 달라지지않는 성질

     2)Patch
    리소스의 일부만 수정하는데 사용
    전체 리소스를 보내는 대신 수정할 부분만 전송
    기존 라소스 데이터는 유지 ,제공된 부분만 업데이트
    -멱등성을 가지지 않음
    -여러번 보내면 동일한 결과 보장하지 않음

    cf)RESTful API추가적인 특징
    /(슬래스)는 게층관계를 나타냄
    : /api/books/1/category/:category
    -밑줄 대신에 하이폰을 사용 권장
    -자원의 리소스의 종류에 따라 단수 , 복수를 구분해서 사용을 권장

     HTTP응답 구조 헤더 바디 -본문
     1)헤더(Header)
     :요청이나 응답에 대한 추가 적인 정보
     EX)메타 데이터 : 데이터 타입,보안 등을 명시
        Content-Type: text-HTML
        Content-Type: application -/json

     2) 바디 body 본문
     : 요청이나 응답의 실제 데이터가 포함

     */

}
