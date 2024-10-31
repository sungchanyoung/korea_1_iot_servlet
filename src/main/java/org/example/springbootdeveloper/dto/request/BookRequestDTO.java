package org.example.springbootdeveloper.dto.request;


import lombok.*;
import org.example.springbootdeveloper.entity.Category;

//책 생성 시 클라이언트 서버에 전달하는 데이터
//요청에 대한 데이터
//request DTO : 클라이언트가 서버에 요청할 때 사용하는 데이터 전송 객체
//주로 새로운 데이터를 생성하거나 기존 데이터를 업데이트할 때 사용되지 그래서 id 필요하지 않음
@Getter
@Setter
@AllArgsConstructor
//@AllArgsConstructor : 즉, 클래스에 있는 모든 필드를 초기화할 수 있는 생성자를 만들어주는 거지.
@NoArgsConstructor
//@NoArgsConstructor: 기본 생성자를 자동으로 만들어줘. 아무런 매개변수가 없는 생성자를 생성해주는 거야.
public class BookRequestDTO {
    private String writer;
    private String title;
    private String content;
    private Category category;
}
