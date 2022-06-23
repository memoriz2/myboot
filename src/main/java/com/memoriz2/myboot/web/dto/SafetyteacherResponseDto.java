package com.memoriz2.myboot.web.dto;

import com.memoriz2.myboot.domain.safetyedu.Safetyteacher;
import lombok.Getter;

@Getter
public class SafetyteacherResponseDto {
    private Long stSeq;
    private String stId;
    private String stTel;

    public SafetyteacherResponseDto(Safetyteacher entity){
        this.stSeq = entity.getStSeq();
        this.stId = entity.getStId();
        this.stTel = entity.getStTel();
    }

}
