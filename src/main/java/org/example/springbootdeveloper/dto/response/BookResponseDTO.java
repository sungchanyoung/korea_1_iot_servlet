package org.example.springbootdeveloper.dto.response;

//서버가 클라이언트에 응답할때 필요한 데이터만 전달

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.springbootdeveloper.entity.Category;

// 서버가 클라이언트에 응답할 때 필요한 데이터만 전달
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//responseDTO :  서버가 클라이언트에게 응답할 때 사용하는 데이터 전송 객체야.
// 이때는 데이터베이스에 저장된 각 항목을 고유하게 식별할 수 있도록 ID가 포함되어야 해.
public class BookResponseDTO {
    private Long id;
    private String writer;
    private String title;
    private String content;
    private Category category;
}
