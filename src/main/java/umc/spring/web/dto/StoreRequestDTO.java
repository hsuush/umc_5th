package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class StoreRequestDTO {
    @Getter
    public static class CreateDto{
        @NotBlank
        String name;

        @NotNull
        String address;

        @NotNull
        String region;
    }

}
