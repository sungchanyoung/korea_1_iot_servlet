package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "board")
public class Board {
    @Id// 해당 필드가 테이블의 기본키(pk)임을 명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //기본키 값을 자동생성 -DB
    private Long id;

    @Column(nullable = false, length=50)
    private String writer;

    @Column(nullable = false, length=100)
    private String title;

    @Column(nullable = false, length=500)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    public Board(String title, String writer, String content, Category category) {
        this.title =title;
        this.writer =writer;
        this.content =content;
        this.category=  category;

    }
}