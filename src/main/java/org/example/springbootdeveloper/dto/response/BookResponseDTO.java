package org.example.springbootdeveloper.dto.response;

//서버가 클라이언트에 응답할때 필요한 데이터만 전달

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.entity.Category;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDTO {
    private  Long id;
    private  String writer;
    private  String title;
    private  String content;
    private Category category;
}
