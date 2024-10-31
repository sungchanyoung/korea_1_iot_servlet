package org.example.springbootdeveloper.dto.request;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor//매개변수 없이 기본 생성자로 사용한다
public class MenuRequestDto {
    @NotNull
    private  String name;
    @NotNull
    private  String description;
    @Min(0)// 제약 조건 없이 최소값이 =0이어야합니다
    @NotNull
    private int price;
    @NotNull
    private boolean isAvailable;
    @NotNull
    private String category;
    private String size;


}
