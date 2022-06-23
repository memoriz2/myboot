package com.memoriz2.myboot.web;

import com.memoriz2.myboot.service.SafetyteacherService;
import com.memoriz2.myboot.web.dto.SafetyteacherResponseDto;
import com.memoriz2.myboot.web.dto.SafetyteacherSaveRequestDto;
import com.memoriz2.myboot.web.dto.SafetyteacherUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class SafetyteacherApiController {
    private final SafetyteacherService safetyteacherService;

    @PostMapping("/api/v1/teacher")
    public Long save(@RequestBody SafetyteacherSaveRequestDto requestDto){
        return safetyteacherService.save(requestDto);
    }

    @PutMapping("/api/v1/teacher/{stSeq}")
    public Long update(@PathVariable Long stSeq, @RequestBody SafetyteacherUpdateRequestDto requestDto){
        return safetyteacherService.update(stSeq, requestDto);
    }

    @GetMapping("/api/v1/teacher/{stSeq}")
    public SafetyteacherResponseDto findById (@PathVariable Long stSeq){
        return safetyteacherService.findById(stSeq);
    }

    @DeleteMapping("/api/v1/teacher/{stSeq}")
    public Long delete(@PathVariable Long stSeq){
        safetyteacherService.delete(stSeq);
        return stSeq;
    }
}
