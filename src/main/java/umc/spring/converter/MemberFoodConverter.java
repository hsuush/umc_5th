package umc.spring.converter;

import umc.spring.domain.FoodType;
import umc.spring.domain.mapping.MemberFoodType;

import java.util.List;
import java.util.stream.Collectors;

public class MemberFoodConverter {
    public static List<MemberFoodType> toMemberFoodList(List<FoodType> foodTypeList){
        return foodTypeList.stream()
                .map(foodType ->
                        MemberFoodType.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
