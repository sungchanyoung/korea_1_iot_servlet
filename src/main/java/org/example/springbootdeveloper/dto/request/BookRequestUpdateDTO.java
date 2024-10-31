package org.example.springbootdeveloper.dto.request;

import lombok.*;
import org.example.springbootdeveloper.entity.Category;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookRequestUpdateDTO {
    //책 id,writer,title , content, category
    //수정이 가능한 데이터 title, content,category

    private  String title;
    private  String content;
    private Category category;
}
