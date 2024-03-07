package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    User addUser(User user);

    Optional<User> findById(long id);

    Page<Course> getEnrolledCourses(Pageable pageable);

    int getCompletedLectureCount(User user, Course course);

}
