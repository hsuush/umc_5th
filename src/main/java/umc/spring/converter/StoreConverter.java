package umc.spring.converter;

import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.StoreRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

import java.time.LocalDateTime;
import java.util.Optional;

public class StoreConverter {
    // 프론트에게 결과로 보내줄 코드
    public static StoreResponseDTO.CreateResultDto toCreateResultDTO(Store store){
        return StoreResponseDTO.CreateResultDto.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    // 들어온 Dto를 Store로 변환
    public static Store toStore(StoreRequestDTO.CreateDto request, Region region){
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .region(region)
                .build();
    }
}
