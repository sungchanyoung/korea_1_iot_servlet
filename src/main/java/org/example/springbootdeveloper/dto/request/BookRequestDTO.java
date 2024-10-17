package org.example.springbootdeveloper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.entity.Category;

//책 생성 시 클라이언트 서버에 전달하는 데이터
//요청에 대한 데이터
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {
    private  String writer;
    private  String title;
    private  String content;
    private Category category;
}
