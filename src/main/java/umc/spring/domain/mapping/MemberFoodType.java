package umc.spring.domain.mapping;

import lombok.*;
import umc.spring.domain.FoodType;
import umc.spring.domain.Member;
import umc.spring.domain.common.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberFoodType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodType foodType;

    public void setMember(Member member) {
        if (this.member != null)
            member.getMemberFoodTypeList().remove(this);
        this.member = member;
        member.getMemberFoodTypeList().add(this);
    }

    public void setFoodType(FoodType foodType) {
            this.foodType = foodType;
    }
}

