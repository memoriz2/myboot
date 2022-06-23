package com.memoriz2.myboot.web.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.memoriz2.myboot.domain.safetyedu.Safetyteacher;
import com.memoriz2.myboot.domain.safetyedu.TeacherRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SafetyteacherApiControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception{
        teacherRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles = "USER")
    public void teacher_등록된다() throws Exception{
        String stId = "stId";
        String stTel = "stTel";
        SafetyteacherSaveRequestDto requestDto = SafetyteacherSaveRequestDto.builder().stId(stId).stTel(stTel).build();

        String url = "http://localhost:"+port+"/api/v1/teacher";

        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Safetyteacher> all = teacherRepository.findAll();
        assertThat(all.get(0).getStId()).isEqualTo(stId);
        assertThat(all.get(0).getStTel()).isEqualTo(stTel);
    }

    @Test
    @WithMockUser(roles = "USER")
    public void teacher_수정된다() throws Exception{
        Safetyteacher savedTeacher = teacherRepository.save(Safetyteacher.builder().stId("stId").stTel("stTel").build());

        Long updateId = savedTeacher.getStSeq();
        String expectedStId = "updateId";
        String expectedStTel = "updateTel";

        SafetyteacherUpdateRequestDto requestDto = SafetyteacherUpdateRequestDto.builder().stId(expectedStId).stTel(expectedStTel).build();

        String url = "http://localhost:"+port+"/api/v1/teacher/"+updateId;

        mvc.perform(put(url).contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        List<Safetyteacher> all = teacherRepository.findAll();
        assertThat(all.get(0).getStId()).isEqualTo(expectedStId);
        assertThat(all.get(0).getStTel()).isEqualTo(expectedStTel);
    }
}
