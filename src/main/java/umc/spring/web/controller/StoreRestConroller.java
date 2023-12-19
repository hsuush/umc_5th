package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.MissionRequestDTO;
import umc.spring.web.dto.MissionResponseDTO;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestConroller {
    private final StoreCommandService storeCommandService;
    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<StoreResponseDTO.CreateResultDto> create(@RequestBody @Valid StoreRequestDTO.CreateDto request){
        Store store = storeCommandService.createStore(request);
        return ApiResponse.onSuccess(StoreConverter.toCreateResultDTO(store));
    }

    @PostMapping("/missions/{storeId}")
    public ApiResponse<MissionResponseDTO.createMissionResultDto> create(@RequestBody @Valid MissionRequestDTO.createMissionDto request, @PathVariable(name="storeId") Long storeId){
        Mission mission = missionCommandService.createMission(request,storeId);
        return ApiResponse.onSuccess(MissionConverter.toMissionResultDto(mission));
    }
}
