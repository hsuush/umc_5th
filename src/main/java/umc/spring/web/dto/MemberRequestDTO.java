package umc.spring.web.dto;

import lombok.Getter;
import umc.spring.domain.enums.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class MemberRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;

        @NotNull
        Integer gender;

        String nickname;

        List<Long> preferCategory;
    }
}
