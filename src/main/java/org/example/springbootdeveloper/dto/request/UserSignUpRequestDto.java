package org.example.springbootdeveloper.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpRequestDto {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String confirmPassword;
}
