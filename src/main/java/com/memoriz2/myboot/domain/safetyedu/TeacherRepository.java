package com.memoriz2.myboot.domain.safetyedu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Safetyteacher, Long> {
    @Query(value = "SELECT * FROM safetyteacher ORDER BY ST_SEQ DESC", nativeQuery = true)
    List<Safetyteacher> findAllDesc();
}

