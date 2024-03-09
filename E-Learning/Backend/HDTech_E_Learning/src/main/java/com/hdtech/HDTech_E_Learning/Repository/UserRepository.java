package com.hdtech.HDTech_E_Learning.Repository;

import com.hdtech.HDTech_E_Learning.Entity.Lecture;
import com.hdtech.HDTech_E_Learning.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameContaining(String keyword, Pageable pageable);
}
