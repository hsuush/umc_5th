package umc.spring.web.controller;

import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
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

    @PostMapping("/{storeId}/members/{memberId}/reviews")
    public ApiResponse<ReviewResponseDTO.CreateReviewResultDto> create(@RequestBody @Valid ReviewRequestDTO.CreateReviewDto request, @PathVariable Long storeId, @PathVariable Long memberId){
        Review review = reviewCommandService.createReview(request, storeId, memberId);
        return ApiResponse.onSuccess(ReviewConverter.toCreateResultDto(review));
    }

    @GetMapping("{storeId}/reviews/{page}")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API",description = "특정 가게의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @Parameters({@Parameter(name = "storeId", description = "가게의 아이디, path variable 입니다!"),
            @Parameter(name = "page", description = "페이지 번호, 0번이 1 페이지 입니다."),
    })
    public ApiResponse<StoreResponseDTO.ReviewPreViewListDTO> getReviewList(@PathVariable(name = "storeId") Long storeId, @PathVariable(name="page")Integer page){
        Page<Review> reviewList = storeCommandService.getReviewList(storeId, page-1);
        return ApiResponse.onSuccess(StoreConverter.reviewPreViewListDTO(reviewList));
    }
}
