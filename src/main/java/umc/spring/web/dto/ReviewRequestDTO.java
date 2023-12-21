package umc.spring.web.dto;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReviewRequestDTO {
    @Getter
    public static class CreateReviewDto{
        @NotNull
        String content;

        @NotNull
        @Min(value=0)
        @Max(value=5)
        Float rating;
    }
}
