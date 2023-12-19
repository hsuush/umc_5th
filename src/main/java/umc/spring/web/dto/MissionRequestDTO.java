package umc.spring.web.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class MissionRequestDTO {
    @Getter
    public static class createMissionDto{
        @NotNull
        Integer point;

        @NotNull
        Integer price;

        LocalDate deadline;

        String content;

    }

}
