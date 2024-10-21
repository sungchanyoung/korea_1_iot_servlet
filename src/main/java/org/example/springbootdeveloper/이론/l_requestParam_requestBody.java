package org.example.springbootdeveloper.이론;

public class l_requestParam_requestBody {
    //Request Para& RequestBody
    /*
    orphaRemoval  =true
     고아 객체 제거
     :post 객체에서 Comments 리스트의 특정 Comment객체을 제거할 경우
     : Comment 엔티티와 Post엔티티간의 다대일 관계
     : 여러 개의 Comment가 하나의 Post에 속함

     -fetch  = FetcType.LAZY
     : Comment 엔티티조회시 Post 엔티티가 즉시 로딩 되지X
     >> getPost()호출 시에만 조회

     JoinColum  : Comment 엔티티가 다대일 관계에서 외래 키를 통해 Post 엔티티와 연관됨을 명시
     @Data
     : LomBok 라이브러리  애너테이션()
      AllArgsContstruvtor  :모든필드 값을 매개변수로 받는 생성자를 자동 생성
      - staticNmae  ="set"
      :set()이라는 이름의 정적메서드 제공
      생성자의 매개변수의 수를 다르게 하기 위함
      :

    Spring에서 클라이언트 로부터 데이터를 받는 방식

    1.@RequestParam - 덜 민감한 정보
    :클라이언트가 url쿼리 스트링 또는 폼 데이터 로 전달한 데이터를
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
