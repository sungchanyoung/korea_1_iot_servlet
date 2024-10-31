package org.example.springbootdeveloper.이론;

public class i_test {
    /*
   테스트 도구

   테스트도구?
   애플리케이션이 의도한 대로 작동하는지 확인하기 위해 작성된 "코드"
   개발자가 직접 코드의 결과를 수작업으로 확인하는 대신
   , "자동화된 테스트"로 특정 기능이 올바르게 동작하는지 반복족으로 확인

   2.테스트 코드의 종류
   : 단위, 통합,기능,화귀

   cf) 테스트 코드는 src 디렉터리 내의 test 디렉토리에서 작업
        given-when -then 패턴
        : 테스트 코드를 세단계로 구분해 작성하는 방식
        given : 테스트의 실행을 준비하는단계
        when : 테스트를 진행하는 단계
        then: 테스트결과를 검증하는 단계

        4.스프링부트3 테스트
        :spring-boot-stater-test:테스트르르위한 도구 모음
        스프링 부트 스타터 테스트 목록
        -jUnit 5 -자바 프로그래밍 언어용 단위 테스트 프레임 워크
        @test 사용
        spring Test  & Spring Boot Test: 스프링 부트용 통합 테스트 지원
        Assertj:검증문인 Assertion작성하는데 사용되는 라이브러리
        JUnit과 함께 사용
        ;검증문 의 가독성을 향상
        cf)  Assertions .assertEquals(sum ,a+b);
        기댓값: sum
        실제 비교값 : a+b
        >> 코드만 보고 기댓값거ㅏ 비교 값이 잘 구분되지 X

        //AssertJ를사용하여 가독성 향상
        cf) assertThat(a+b).isEqualTo(sum);
        a와b를 더한 값이 sum과 같아야한다

        AssertJ의 메서드
        1)isEqualTo(A): A값과 같은지 검증
        -isNotEqualTo(A):A값과 다른지 검증
        -contains(A :A값과 같은지 검증
        -doesNotCOntains(A) : A값을 포함하는지 검증
        -startsWith(A : 접두사가A인즤 검증
        -endsWith(A : 접미사가A인즤 검증
         -isEmpty: 비어있는지 검증
         -isNotEmpty: 안비워져있는지 검증
          ispositive(A): 양수인지 검증
      - isNegative(): 음수인지 검증
      - isGreaterThan(1): 1보다 큰 값인지 검증
      - isLessThan(1): 1보다 작은 값인지 검증



     */
}
