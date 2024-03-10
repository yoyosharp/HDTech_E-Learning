package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.User;
import com.hdtech.HDTech_E_Learning.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements RecordService<Course>{

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course add(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> addAll(List<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    @Override
    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }

    @Override
    public Page<Course> findByNameContaining(String keyword, Pageable pageable) {
        return courseRepository.findByNameContaining(keyword, pageable);
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

}
