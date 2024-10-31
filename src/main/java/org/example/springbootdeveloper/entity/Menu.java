package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// DB의 auto_increment 설정
    private Long id; // 메뉴 고유 ID

    @NotBlank // 문자열 필드가 빈 문자열이 아니고 null이 아님을 보장하는 유효성 검사 -
    // 공백이나 빈 문자열 입력 방지
    private String userEmail; // 메뉴를 등록한 사람의 userEmail

    @Column(nullable = false, length = 255)
    private String name; // 메뉴명

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description; // 메뉴 설명

    @Column(nullable = false)
    private int price; // 메뉴 가격

    @Column(nullable = false)
    private boolean isAvailable; // 메뉴 이용가능 여부

    @Column(nullable = false, length = 100)
    private String category; // 메뉴 카테고리 - Food, Drink, Dessert 값으로 제한

    @Column(length = 50, columnDefinition = "VARCHAR(50) DEFAULT 'Regular'")
    private String size; // 메뉴 사이즈 - Regular 값을 기본값으로 설정

    @Builder
    public Menu(String name, String userEmail, String description, int price
            , boolean isAvailable, String category, String size) {
        this.name = name;
        this.userEmail = userEmail;
        this.description = description;
        this.price = price;
        this.isAvailable = isAvailable;
        this.category = category;
        this.size = size;
    }
}