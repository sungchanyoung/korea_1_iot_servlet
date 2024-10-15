package org.example.springbootdeveloper.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

@NoArgsConstructor//기본생성자
@AllArgsConstructor
@Getter
@Setter
//dto:데이터를 담고 있는 컨테이너
public class StudentDto {
    private  Long id;
    private  String name;
    private  String email;


}
