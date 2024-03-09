package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.User;
import com.hdtech.HDTech_E_Learning.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements RecordService<User>{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> addAll(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public Optional<User> findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Page<User> findByNameContaining(String keyword, Pageable pageable) {
        return userRepository.findByNameContaining(keyword, pageable);
    }

    Page<Course> getEnrolledCourses(Pageable pageable) {
        return null;
    }

    int getCompletedLectureCount(User user, Course course) {
        return 0;
    }

}
