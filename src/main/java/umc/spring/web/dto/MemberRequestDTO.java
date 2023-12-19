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

        String nickname;

        @NotNull
        Integer gender;

        String address;

        String specAddress;

        String email;
        List<Long> preferCategory;
    }
}
