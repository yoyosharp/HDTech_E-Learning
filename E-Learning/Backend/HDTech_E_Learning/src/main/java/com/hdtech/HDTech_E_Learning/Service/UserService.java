package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Course;
import com.hdtech.HDTech_E_Learning.Entity.Enrollment;
import com.hdtech.HDTech_E_Learning.Entity.Lecture;
import com.hdtech.HDTech_E_Learning.Entity.User;
import com.hdtech.HDTech_E_Learning.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements RecordService<User>{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EnrollmentService enrollmentService;

    @Autowired
    private LectureService lectureService;

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
        return userRepository.findByUserNameContaining(keyword, pageable);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void enroll(User user, Course course) {

        List<Long> enrolledCourseIDs = user.getEnrollments().stream()
                .map(enrollment -> enrollment.getCourse().getId())
                .toList();

        if (!enrolledCourseIDs.contains(course.getId())) {
            Enrollment enrollment = new Enrollment();
            enrollment.setUser(user);
            enrollment.setCourse(course);

            user.getEnrollments().add(enrollment);

            enrollmentService.add(enrollment);
        }
    }

    public List<Lecture> getEnrolledLectures(User user) {
        List<Lecture> enrolledLectures = new ArrayList<>();

        user.getEnrollments()
                .forEach(enrollment -> enrolledLectures.addAll(enrollment.getCourse().getLectures()));

        return enrolledLectures;
    }

    public void completeLecture(User user, Lecture lecture) {
        List<Long> completedLectures = user.getCompletedLectures().stream()
                .map(lecture1 -> lecture1.getId())
                .toList();

        if (!completedLectures.contains(lecture.getId())) user.getCompletedLectures().add(lecture);

        userRepository.save(user);
    }

    public Page<Course> getEnrolledCourses(User user, Pageable pageable) {
        return null;
    }

    public int getCompletedLectureCount(User user, Course course) {
        return 0;
    }

}
