package org.example.springbootdeveloper.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
public class CommentRequestDto {
    private  Long  postId;
    private  String content;
    private  String commenter;

}
