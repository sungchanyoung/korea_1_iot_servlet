package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.controller.StudentController;
import org.example.springbootdeveloper.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//jparepository를 상속받음
//cf) implements키워드
//: 인터페아스를 구현
public interface StudentRepository  extends JpaRepository <Student, Long>{
//jpaRepositoty인터페이스는 기본적인 CRUD와 페이징 정렬의 메서드가 포함
// : JpaRepository 인터페이스를 상속받음
    // : 해당 인터페이스는 기본적인 CRUD와 페이징, 정렬의 메서드가 포함
    // >> 직접 구현할 필요 X, 인터페이스만 선언하면 스프링이 자동으로 구현체를 만들어 줌
    // >> 필요한 경우 사용자 정의 쿼리 추가 가능

}
