package com.hdtech.HDTech_E_Learning.Service;

import com.hdtech.HDTech_E_Learning.Entity.Lecture;
import com.hdtech.HDTech_E_Learning.Entity.User;
import com.hdtech.HDTech_E_Learning.Repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LectureService implements RecordService<Lecture>{

    @Autowired
    private LectureRepository lectureRepository;

    @Override
    public Lecture add(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    @Override
    public List<Lecture> addAll(List<Lecture> lectures) {
        return lectureRepository.saveAll(lectures);
    }

    @Override
    public Optional<Lecture> findById(long id) {
        return lectureRepository.findById(id);
    }

    @Override
    public Page<Lecture> findByNameContaining(String keyword, Pageable pageable) {
        return lectureRepository.findByNameContaining(keyword, pageable);
    }

    @Override
    public List<Lecture> findAll() {
        return null;
    }

}
