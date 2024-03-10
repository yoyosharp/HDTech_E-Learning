package com.hdtech.HDTech_E_Learning.Controller;

import com.hdtech.HDTech_E_Learning.Entity.*;
import com.hdtech.HDTech_E_Learning.Repository.CategoryRepository;
import com.hdtech.HDTech_E_Learning.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Initialize {
    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private LectureService lectureService;

    @Autowired
    private EnrollmentService enrollmentService;

    @Value("${literal.default-user-password}")
    private String defaultUserPassword;
    @Value("${literal.default-user-photo}")
    private String defaultUserPhoto;

    @Value("${literal.default-category-photo}")
    private String defaultCategoryPhoto;

    @Value("${literal.default-course-photo}")
    private String defaultCoursePhoto;

    @Value("${literal.default-lecture-photo}")
    private String defaultLecturePhoto;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private Random random = new Random();

    @RequestMapping("/initialize")
    public ResponseEntity<?> initialize() {
        createRoles();
        createUsers(10);
        createCategories(5);
        createCourses(10);
        createLectures(100);

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @RequestMapping("/randomEnrollment")
    public ResponseEntity<?> randomEnrollment() {
        List<User> users = userService.findAll().stream().filter(user -> user.getRole().getId() == 2).toList();
        List<Course> courses = courseService.findAll();

        for (User user: users) {
            //generate random number of courses
            int toEnrollCourseCount = random.nextInt(courses.size() + 1);
            //enroll random courses
            for (int i = 0; i < toEnrollCourseCount; i++) {
                userService.enroll(user, courses.get(random.nextInt(courses.size())));
            }
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @RequestMapping("/randomFinishing")
    public ResponseEntity<?> randomFinishLecture(){
        List<User> users = userService.findAll().stream().filter(user -> user.getRole().getId() == 2).toList();

        for (User user: users) {
            List<Lecture> enrolledLecture = userService.getEnrolledLectures(user);
            //generating a random number of lectures
            int toFinishingLecture = random.nextInt(enrolledLecture.size() + 1);
            //randomly finish user's lectures
            for (int i = 0; i < toFinishingLecture; i++) {
                Lecture toCompleteLecture = enrolledLecture.get(random.nextInt(enrolledLecture.size()));

                userService.completeLecture(user, toCompleteLecture);
            }
        }

        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    private void createRoles() {
        Role admin = new Role("ROLE_ADMIN");
        Role user = new Role("ROLE_USER");

        List<Role> list = new ArrayList<>();
        list.add(admin);
        list.add(user);

        roleService.addAll(list);
    }

    private void createUsers(int count) {
        List<User> users = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            User user = new User();
            user.setUserName("User" + i);
            user.setEmail("user" + i + "@gmail.com");
            user.setPhoto(defaultUserPhoto);
            user.setPassword(passwordEncoder.encode(defaultUserPassword));
            user.setStatus(1);

            if (i < 2) {
                Role admin = roleService.findById(1)
                        .orElseThrow(() -> new RuntimeException("Cannot find role 'admin'"));
                user.setRole(admin);
            }
            else {
                Role userRole = roleService.findById(2)
                        .orElseThrow(() -> new RuntimeException("Cannot find role 'user'"));
                user.setRole(userRole);
            }

            users.add(user);
        }

        userService.addAll(users);
    }

    private void createCategories(int count) {

        List<Category> categories = new ArrayList<>();

        for (int i = 1; i <= count; i++) {
            Category category = new Category();
            category.setName("Category" + i);
            category.setPhoto(defaultCoursePhoto);

            categories.add(category);
        }

        categoryService.addAll(categories);
    }

    private void createCourses(int count) {

        List<Course> courses = new ArrayList<>();
        List<Category> categories = categoryService.findAll();
        for (int i = 1; i <= count; i++) {
            Course course = new Course();
            course.setName("Course" + i);
            course.setPhoto(defaultCoursePhoto);
            Category category = categories.get(i % categories.size());

            course.setCategory(category);

            courses.add(course);
        }

        courseService.addAll(courses);
    }

    private void createLectures(int count) {
        List<Lecture> lectures = new ArrayList<>();
        List<Course> courses = courseService.findAll();

        for (int i = 1; i <= count; i++) {
            Lecture lecture = new Lecture();
            lecture.setName("Lecture" + i);
            lecture.setPhoto(defaultLecturePhoto);

            Course course = courses.get(random.nextInt(courses.size()));

            lecture.setCourse(course);

            lectures.add(lecture);
        }

        lectureService.addAll(lectures);
    }

}
