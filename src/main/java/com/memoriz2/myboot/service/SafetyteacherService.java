package com.memoriz2.myboot.service;

import com.memoriz2.myboot.domain.safetyedu.Safetyteacher;
import com.memoriz2.myboot.domain.safetyedu.TeacherRepository;
import com.memoriz2.myboot.web.dto.SafetyteacherResponseDto;
import com.memoriz2.myboot.web.dto.SafetyteacherSaveRequestDto;
import com.memoriz2.myboot.web.dto.SafetyteacherUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SafetyteacherService {
    private final TeacherRepository teacherRepository;
    public Long save(SafetyteacherSaveRequestDto requestDto) {
        return teacherRepository.save(requestDto.toEntity()).getStSeq();
    }

    @Transactional
    public Long update(Long stSeq, SafetyteacherUpdateRequestDto requestDto){
        Safetyteacher safetyteacher = teacherRepository.findById(stSeq).orElseThrow(() -> new IllegalArgumentException("해당 강사가 없습니다. stSeq="+ stSeq));
        safetyteacher.update(requestDto.getStId(), requestDto.getStTel());
        return stSeq;
    }

    public SafetyteacherResponseDto findById (Long stSeq){
        Safetyteacher entity = teacherRepository.findById(stSeq).orElseThrow(() -> new IllegalArgumentException("해당 강사가 없습니다. stSeq="+stSeq));
        return new SafetyteacherResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<SafetyteacherResponseDto> findAllDesc(){
        return teacherRepository.findAllDesc().stream()
                .map(SafetyteacherResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long stSeq){
        Safetyteacher st = teacherRepository.findById(stSeq)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. stSeq="+stSeq));
        teacherRepository.delete(st);
    }
}
