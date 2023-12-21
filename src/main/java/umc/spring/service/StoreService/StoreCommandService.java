package umc.spring.service.StoreService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

public interface StoreCommandService {
    Store createStore(StoreRequestDTO.CreateDto request);

    Page<Review> getReviewList(Long storeId, Integer page);

}
