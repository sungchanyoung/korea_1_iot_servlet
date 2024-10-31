package org.example.springbootdeveloper.이론;

public class s_ReponseEntity {
    /*
    1.resonseEntity
    Spring에서 제공하느 HTTpEntity 를 상속받는 클래스
    클라이언트에게 HTTP 응답을 전송할 때
    "상태 코드",'헤더 정보',응답 본문(body)를 모두 포함하여 응답
    1)HTTP상태 코드 ->성공 실ㄹ패 등 다양한 HTTP상태 코드를 명시적으로 설정
    2)헤더 정보
    :content-type등의 응답 헤더
    3)응답 바디
    : 응답 본문 보낼 수 있음
    ResponseEntity <T>의 제네릭 클래스 구조
    <T>는 응답 본문의 타입을 지정
    ResonponseEntity

    200=ok
    201 created = 새로운 리소가 성공으로 생성
    400 BAD REQUEST잘못된 요청
    403 FORBIDDEN:권한 없음
    404 NOT FOUND:요청한 리소스를 서버 내부 오류
    500 INTERNAL SERVER ERROR: 서버 내부 오류

    ResponseEntity 반환 방법
    1.new ResponseEntity<>(응답 본문 ,헤더 ,상태 코드);
    2.ResponseEntity .status(Http.상태 코드).header(헤더).body(응답본문)

    ResonseEntity vs ResponseDto
    1.ResponseEntity
    : Http응답 전체를 구성하는 객체
    -응답에 상태 코드나 헤더 정보를 추가호 포함해야 할 때 사용
    2.ResponseDto
    :응답 바디에 들어갈 데이터 구조를 정의 하는 역활
    -클라이언트에게 응답할 데이터의 형태를 정의
     */
}
