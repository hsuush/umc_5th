package umc.spring.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.Exception.handler.StoreHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.FoodType;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.FoodTypeRepository;
import umc.spring.repository.RegionRepository;
import umc.spring.repository.StoreRepository;
import umc.spring.web.dto.StoreRequestDTO;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;
    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public Store createStore(StoreRequestDTO.CreateDto request) {
        Region region = regionRepository.findByName(request.getRegion()).orElseThrow(()->new StoreHandler(ErrorStatus.REGION_NOT_FOUND));
        Store newStore = StoreConverter.toStore(request, region);

        return storeRepository.save(newStore);
    }
}
