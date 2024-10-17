package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//DTO는 데이터를 옮기는 데 집중하고,
// Entity는 데이터베이스와의 직접적인 상호작용

@Entity
//@Entity를 통해 클래스가 데이터베이스와 연결된다는 걸 명시하는 거지
@Table(name = "students")
@Getter
@Setter//해당 엔티티가 students라는 이름의 테이블과 매핑됨을 명시
public class Student {
@Id // 해당 필드가 테이블의 기본 키(PK)임을 명시
@GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키 값을 자동 생성 - DB의 생성 IncreMent를 사용
    private Long id;
    private String name;
    private String email;
//JPA(Java Persistence API)는 자바 애플리케이션에서 객체와 관계형 데이터베이스 간의 매핑을 제공하는 표준 API
    protected Student() {
        // JPA는 엔터티 생성 시 기본 생성자를 사용 - 필수
    }

    public Student(String name, String email) {
        this.name = name;
        this.email = email;

    }
}
