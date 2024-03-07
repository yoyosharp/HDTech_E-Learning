package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Lecture;

import java.util.Optional;

public interface LectureService {
    Lecture addLecture(Lecture lecture);

    Optional<Lecture> findById(long id);

}
