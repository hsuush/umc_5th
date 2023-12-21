package umc.spring.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.converter.ReviewConverter;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.service.ReviewCommandService.ReviewCommandService;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreRestConroller {
    private final StoreCommandService storeCommandService;
    private final MissionCommandService missionCommandService;
    private final ReviewCommandService reviewCommandService;

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

    @PostMapping("/reviews/{storeId}/{memberId}")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDto> create(@RequestBody @Valid ReviewRequestDTO.CreateReviewDto request, @PathVariable Long storeId, @PathVariable Long memberId){
        Review review = reviewCommandService.createReview(request, storeId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDto(review));
    }
}
