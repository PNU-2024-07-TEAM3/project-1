package com.ll.crapp.studyroom;

import com.ll.crapp.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class StudyRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;       // 스터디룸의 제목
    private int dayNo;        // 스터디룸 일차
    private String learningObjective; // 학습 목표
    private LocalDate endDate;  // 종료 일자
    private boolean isOpen;     // 스터디룸 오픈 여부

    @ManyToMany(mappedBy = "studies")
    private Set<SiteUser> members = new HashSet<>();
}
  
