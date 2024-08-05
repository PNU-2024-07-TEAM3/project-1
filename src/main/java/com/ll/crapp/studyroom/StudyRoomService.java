package com.ll.crapp.studyroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyRoomService {

    @Autowired
    private StudyRoomRepository studyRoomRepository;

    public StudyRoom save(StudyRoom studyRoom) {
        return studyRoomRepository.save(studyRoom);
    }

    public List<StudyRoom> findByTitle(String title) {
        return studyRoomRepository.findByTitle(title);
    }

    public List<StudyRoom> findAll() {
        return studyRoomRepository.findAll();
    }


    public List<StudyRoom> findByTitleAndDayNo(String title, int dayNo) {
        return studyRoomRepository.findByTitleAndDayNo(title, dayNo);
    }

}
