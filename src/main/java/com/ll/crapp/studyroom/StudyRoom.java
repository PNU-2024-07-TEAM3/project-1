package com.ll.crapp.studyroom;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "studyrooms")
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // 스터디룸의 제목
    private int day;        // 스터디룸 일차
    private String learningObjective; // 학습 목표
    private LocalDate endDate;  // 종료 일자
    private boolean isOpen;     // 스터디룸 오픈 여부

    // 기본 생성자
    public StudyRoom() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
  
