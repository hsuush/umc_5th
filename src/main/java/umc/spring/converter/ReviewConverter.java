package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.ReviewResponseDTO;

import java.time.LocalDateTime;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO.CreateReviewDto request, Store store, Member member){
        return Review.builder()
                .content(request.getContent())
                .rating(request.getRating())
                .store(store)
                .member(member)
                .build();
    }

    public static ReviewResponseDTO.CreateReviewResultDto toCreateResultDto(Review review){
        return ReviewResponseDTO.CreateReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
