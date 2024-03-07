package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.Enrollment;
import com.hdtech.HDTech_E_Learning.Entity.User;

import java.util.Optional;

public interface EnrollmentService {
    Enrollment enroll(User user, Course course);
}
