package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
//entity와Dto
//dto: 데이터를 옮기는데 집중하고
// entity: 데이터베이스와 직접적인 상호작용
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
    @Id
    //strategy = GenerationType.IDENTITY: 이 전략은 기본 키를 데이터베이스가 자동으로 생성하도록 해.
    // 일반적으로 MySQL 같은 데이터베이스에서 AUTO_INCREMENT 특성을 사용하는 경우에 사용해.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",updatable = false)
    private  Long id; //DB 테이블의 id 컬럼과 매칭
    @Column(name = "name", nullable = false)
    private  String name;



}
