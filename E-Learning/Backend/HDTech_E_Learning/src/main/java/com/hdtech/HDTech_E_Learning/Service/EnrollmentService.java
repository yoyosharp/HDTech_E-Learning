package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.Enrollment;
import com.hdtech.HDTech_E_Learning.Entity.User;
import com.hdtech.HDTech_E_Learning.Repository.EnrollmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EnrollmentService implements RecordService<Enrollment>{

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Override
    public Enrollment add(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    @Override
    public List<Enrollment> addAll(List<Enrollment> enrollments) {
        return enrollmentRepository.saveAll(enrollments);
    }

    @Override
    public Optional<Enrollment> findById(long id) {
        return enrollmentRepository.findById(id);
    }

    @Override
    public Page<Enrollment> findByNameContaining(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public List<Enrollment> getUserEnrollment(User user) {
        return enrollmentRepository.getUserEnrollment(user.getId());
    }
}
