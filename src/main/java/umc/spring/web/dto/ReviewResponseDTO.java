package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ReviewResponseDTO {
    @Getter
    @Builder
    public static class CreateReviewResultDto{
        Long reviewId;
        LocalDateTime createdAt;
    }
}
