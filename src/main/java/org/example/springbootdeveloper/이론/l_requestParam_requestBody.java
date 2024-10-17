package org.example.springbootdeveloper.이론;

public class l_requestParam_requestBody {
    //Request Para& RequestBody
    /*
    Spring에서 클라이언트 로부터 데이터를 받는 방식

    1.@RequestParam
    :클라이언트가 url쿼리 스트링 또는 폼 데이터 로 전달한 데이터르르
    ,컨트롤러 메서드의 파라미터로 받을때 사용
    주로 Get 요청에서 많이 사용
    데이터를 URL뒤에 붙여서 전달하는경우

    URL에서 데이터를 전달할 때 검색 조건 ,필터링 등의 간단한 데이터 요청할 때
    GET요청
    보안에 덜 민감한 데이터

    @RequestBody
    HTTP요청의 본문에 담긴 JSON 또는 XML 같은 데이터를 ,객체로 변환하여 받을때 사용
    주로 post,put,delete와 같은 요총에서 데이터를 전송할 때  사용

    post/put 요청에서 데이터를 전달
    복잡한 데이터 구조 : 주로 DTO(data transfer object)를 사용해 데이터를 변환
    //보안이 중요한다

    민감 정보는 RequestBody
    2) 기본값 설정 public String getName(@RequestParam(required = false, default ="default") String name)

     */
}
