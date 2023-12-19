package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;
import umc.spring.domain.Mission;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class MissionResponseDTO {
    @Builder
    @Getter
    public static class createMissionResultDto{
        Long missionId;
        LocalDateTime createdAt;
    }

}
