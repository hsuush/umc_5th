package umc.spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.Exception.handler.FoodTypeHandler;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberFoodConverter;
import umc.spring.domain.FoodType;
import umc.spring.domain.Member;
import umc.spring.domain.mapping.MemberFoodType;
import umc.spring.repository.FoodTypeRepository;
import umc.spring.repository.MemberRepository;
import umc.spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;
    private final FoodTypeRepository foodTypeRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){
        Member newMember = MemberConverter.toMember(request);
        List<FoodType> foodTypeList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodTypeRepository.findById(category).orElseThrow(()->new FoodTypeHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberFoodType> memberFoodList = MemberFoodConverter.toMemberFoodList(foodTypeList);

        memberFoodList.forEach(memberFoodType->{memberFoodType.setMember(newMember);});
        return memberRepository.save(newMember);
    }

}
