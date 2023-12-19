package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    // request -> mission으로
    public static Mission toMission(MissionRequestDTO.createMissionDto request, Store store){
        return Mission.builder()
                .point(request.getPoint())
                .price(request.getPrice())
                .content(request.getContent())
                .deadline(request.getDeadline())
                .authCode(request.getContent())
                .store(store)
                .build();
    }

    public static MissionResponseDTO.createMissionResultDto toMissionResultDto(Mission mission){
        return MissionResponseDTO.createMissionResultDto.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    //
}
