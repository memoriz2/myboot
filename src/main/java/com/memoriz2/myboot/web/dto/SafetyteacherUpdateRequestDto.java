package com.memoriz2.myboot.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SafetyteacherUpdateRequestDto {
    private String stId;
    private String stTel;

    @Builder
    public SafetyteacherUpdateRequestDto(String stId, String stTel){
        this.stId = stId;
        this.stTel = stTel;
    }
}
