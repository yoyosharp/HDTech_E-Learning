package com.hdtech.HDTech_E_Learning.Repository;

import com.hdtech.HDTech_E_Learning.Entity.Category;
import com.hdtech.HDTech_E_Learning.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Page<Course> findByNameContaining(String keyword, Pageable pageable);
}
