package org.example.springbootdeveloper.이론;

public class k_JpaRepository {
    /*
        JpaRepository
        :Spring data jpa에서 제공하는 기본 인터페이스
        : CRUD와 페이징 , 정렬 포함한 다양한 데이터 엑세스 메서드를 제공

        1 CRUD 메서드
        save(S enttity) :S
        -새로운 에터티를 저장하거나 , 기존 엔터티를 업데이트

        2-findById(ID id)
        -주언진 ID에 해당하는 엔터티를 조회

        3-existsById(ID id):boolen
        - 주어닞 ID가 존재하는지 확인

        4-findAll()
        :데이터베이스에 있는 모든 엔티티 조회

        5-deleteBy Id (ID id): void
        :주어진 ID 엔터티를 삭제

        2.JpaRepository<타입 1, 타입2>의 구조
        1) 타입 1
         엔터티(Entity)클래스타입
         DB테이블과 매핑되는 클래스
         2)타입2
         엔터티 ID타입
         해당 엔티티 의 기본키 필드에 사용된 데이터 타입

        3. 쿼리 메서드 사용
         :사요자 정의 메서드
         -메서드 이름으로 쿼리 생성
         메서드 이름을 분석해 자동으로 쿼리생성
         주로 WHERE,LIKE BETWEEN ORDER BY를 지원

        findById(ID id)
        find -> select:조회
        By :뒤의 키워드로 조회


         EX 가격이 특정 큼액 이상인 상품  조회
         findByPriceGeraterThan(int price);
         -Grater than(이상)
         2-이름에 특정 문자열이 포함된 상품 조회
         findByNameContaining(String keyword);
         -containing

         3- 카테고리가 일치하고 가격이 특정 범위에 있는 상품 조회
         findByCategoryAndPriceBetween(String category ,int minPrice, int maxPrice);

         4-특정 날짜 이후에 생성된 '상품 조회'
         findByCreatedDate After OrderBy CreatedDated Desc(Local date);
         after:이후
         order by a(a를 기준)
         DESC내림 차순

         @Query어노테이션 사용해 직접 sq작성
         findByPriceGreaterThan(1000)
         @Query("SELECT *FROM PRODUCT p WHERE p.price> : price")

         @Query 어노테이션 사용해 직접 sql작성

     */

}
