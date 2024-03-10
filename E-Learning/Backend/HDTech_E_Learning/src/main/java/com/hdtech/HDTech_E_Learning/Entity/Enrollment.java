package com.hdtech.HDTech_E_Learning.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.time.LocalDate;


@Entity
@Table(name = "enrollment")
@Data
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;

    public Enrollment() {
        date = LocalDate.now();
    }
}
