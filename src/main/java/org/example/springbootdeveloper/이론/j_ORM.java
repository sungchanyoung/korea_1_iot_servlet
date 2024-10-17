package org.example.springbootdeveloper.이론;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class j_ORM {
    //1.ORM (OB)
    //객체와 관계형 데이터 베이스간의 데이터를 매핑해주는 기술
    // 데이터베이스 테이블과 애플리케이션 객체간의 구조적 불일치를 해결하는 솔루션
    //cf) RDBMS: user_password(lower-snake-case)- 테이블
    //cf) java: userPassword(lowerCamelCase)- 클래스

    //ORM의 특징과 장점
    //-객체와 테이블이 매핑 1:1로 연결하여 데이터를 매핑
    // 객체지향적인 데이터 조작 :SQL 대신 자바 객체 메서드로 CRUD 작업 수행
    // 반볻적인 SQL작성없이 데이터 조작이 가능, DBMS에 독립적
    //학습 곡선 높음 , 복잡한 쿼리 작성 어려움

    //2) ORM 동작원리
    // 각 테이블은 클래스에 ,테이블의 각 행(row)은 객체에 매핑
    //Entity: 데이터베이스 테이블과 매핑되는 클래스
    //Field:클래스의 필드는 테이블의 열(colum)
    //2.JPA(Java Persistence API)
//   ORM의 종류중 하나
//    java 애플리케이션에서 관계형 데이터베이스를 쉽게 다률 수 있는 ORM 표준

    //영속성 컨텍스트
    // : 엔티티의 생명주기를 관리하는 공간
    // : DB와의연결을  유지하면서 엔티티 객체들을 관리
    // - 고객 테이블
//    create  database example_orm;
//    use example_orm;
//    create table example_orm(
//            id int primary key auto_increment,
//            name varchar(50),
//    email varchar(50)
//);

    //클래스
//    @Entity
//    public  class  Customer{
//        @Id
//        @GeneratedValue(strategy = GenerationType.IDENTITY)
//        private int id;
//        private  String name;
//        private String email;
//
//    }

    //3.ORM에서 사용되는 주요 애너테이션
    //@Entity: 클래스 DB테이블과 매핑할 때 사용
    //-옵션 없이 사용 가능
    //+) name  옵션 :엔티티 이름을 지정 ,테이블과 다를 경우 명시
    // @Entity(name ="userTable")
    //public class user{ }
    //@Id : 해당 필드를 DB테이블의 기본키로 지정
    //- 옵션 없이 사용 ,다른 애너테이션 과 함께  기본 키 생성 방식이나 타입 설정 가능

    //  +) 주로 GeneratedValue와 함께 사용
    // :기본키 자동 생성 전랙 설정
    // +  다양한 옵션이 있음
    // -startegy 옵션 :generationType.INENTITY(auto_increment)

    //@Column
    //:필드를 특정 테이블 열과 매핑
    // 생략 기본으로 필드 이름이 열 이름으로 사용
    // 다양한  옵션 열 이름 지정
    //nullable 옵션 열이 null값을 허용할지 여부를 결정 기본값 true
    //length옵션 - String 타입의  열이 길이를 지정 -기본값255
    //unique : 해당 필드의 값이 유일해야하는지 여부를 지정(기본값 false)

    //@Table 클래스가 어떤 테이블과 매핑되는지 명시
    //생략시 기븐으로 클래스 이름이 테이블 이름으로 사용
    //name 옵션

    //옵션은 '옵션명 = 옵션 사항'으로 명시
    // 각 옵션은 ,(콤마)로 구분
    //@Colum(name ='user_password', nullalble =false, unique =true)

    /*
    cf) JPA(ORM , 객체와 RDMBS의 연결 ) VS MyBatis(SQL Mapper)


    -환경 설정
    1-필요한 의존성 :Spring Data JPA, MySQL Driver
    2- application .properties, application.yml
    애플리케이션 설정 : 연결할 DB와 사용자정보  비밀번호 설정
     */
}
