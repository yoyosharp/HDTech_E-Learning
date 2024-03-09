package com.hdtech.HDTech_E_Learning.Repository;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.Lecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long> {

    Page<Lecture> findByNameContaining(String keyword, Pageable pageable);
}
