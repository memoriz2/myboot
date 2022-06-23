package com.memoriz2.myboot.web;

import com.memoriz2.myboot.config.auth.LoginUser;
import com.memoriz2.myboot.config.auth.dto.SessionUser;
import com.memoriz2.myboot.service.SafetyteacherService;
import com.memoriz2.myboot.web.dto.SafetyteacherResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RequiredArgsConstructor
@Controller
public class IndexController {

    private final SafetyteacherService safetyteacherService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("teacher", safetyteacherService.findAllDesc());

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/teacher/save")
    public String teacherSave(){
        return "teacher-save";
    }

    @GetMapping("/teacher/update/{stSeq}")
    public String teacherUpdate(@PathVariable Long stSeq, Model model){
        SafetyteacherResponseDto dto = safetyteacherService.findById(stSeq);
        model.addAttribute("teacher", dto);

        return "teacher-update";
    }
}
