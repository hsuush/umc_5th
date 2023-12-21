package umc.spring.service.ReviewCommandService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {
    Review createReview(ReviewRequestDTO.CreateReviewDto request, Long storeId, Long memberId);
}
