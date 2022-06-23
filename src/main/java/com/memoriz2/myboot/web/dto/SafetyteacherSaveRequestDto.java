package com.memoriz2.myboot.web.dto;

import com.memoriz2.myboot.domain.safetyedu.Safetyteacher;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SafetyteacherSaveRequestDto {
    private String stId;
    private String stTel;

    @Builder
    public SafetyteacherSaveRequestDto(String stId, String stTel){
        this.stId = stId;
        this.stTel = stTel;
    }

    public Safetyteacher toEntity(){
        return Safetyteacher.builder().stId(stId).stTel(stTel).build();
    }
}
