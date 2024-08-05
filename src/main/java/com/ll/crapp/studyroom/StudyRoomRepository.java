package com.ll.crapp.studyroom;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long> {
    List<StudyRoom> findByTitle(String title);
    List<StudyRoom> findByTitleAndDayNo(String title, int day);
}
