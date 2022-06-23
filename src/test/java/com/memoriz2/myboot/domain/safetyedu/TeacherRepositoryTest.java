package com.memoriz2.myboot.domain.safetyedu;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    TeacherRepository teacherRepository;

    @After
    public void cleanup(){
        teacherRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        String stId = "테스트 게시글";
        String stTel = "테스트 본문";

        teacherRepository.save(Safetyteacher.builder().stId(stId).stTel(stTel).build());

        List<Safetyteacher> teacherList = teacherRepository.findAll();

        Safetyteacher teacher = teacherList.get(0);
        assertThat(teacher.getStId()).isEqualTo(stId);
        assertThat(teacher.getStTel()).isEqualTo(stTel);
    }

    @Test
    public void BaseTimeEntity_등록(){
        LocalDateTime now = LocalDateTime.of(2019,6,4,0,0,0);
        teacherRepository.save(Safetyteacher.builder().stId("stId").stTel("stTel").build());

        List<Safetyteacher> teacherList = teacherRepository.findAll();

        Safetyteacher teacher = teacherList.get(0);

        System.out.println(">>>>>>>>> createDate="+teacher.getCreatedDate()+", modifiedDate="+teacher.getModifiedDate());

        assertThat(teacher.getCreatedDate()).isAfter(now);
        assertThat(teacher.getModifiedDate()).isAfter(now);
    }
}
