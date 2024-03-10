package com.hdtech.HDTech_E_Learning.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RecordService<T>{
    T add(T t);

    List<T> addAll(List<T> ts);

    Optional<T> findById(long id);

    Page<T> findByNameContaining(String keyword, Pageable pageable);

    List<T> findAll();
}
