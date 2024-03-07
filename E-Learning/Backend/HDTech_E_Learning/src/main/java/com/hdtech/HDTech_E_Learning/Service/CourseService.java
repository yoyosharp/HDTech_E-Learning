package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CourseService {
    Course addCourse(Course course);

    Optional<Course> findById(long id);

    Page<Course> findByName(String keyword, Pageable pageable);
}
