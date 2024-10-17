package org.example.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.entity.Category;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BoardDTO {
    private Long id;
    private String title;
    private String writer;
    private String content;
    private Category category;
    BoardDTO( String title, String writer, String content ,Category category){
         this.title = title;
         this.writer = writer;
         this.content = content;
         this.category =category;
    }
}

