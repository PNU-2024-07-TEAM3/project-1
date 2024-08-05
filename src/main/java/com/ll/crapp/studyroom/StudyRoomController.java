package com.ll.crapp.studyroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class StudyRoomController {

    @Autowired
    private StudyRoomService studyRoomService;

    @GetMapping("/studyroom/{title}")
    public String showStudyRooms(@PathVariable String title, Model model) {
        List<StudyRoom> studyRooms = studyRoomService.findByTitle(title);
        model.addAttribute("studyRooms", studyRooms);
        return "studyroom_list";
    }

    @GetMapping("/studyroom/{title}/{day}")
    public String studyRoom(@PathVariable String title, @PathVariable int day, Model model) {
        List<StudyRoom> studyroom = studyRoomService.findByTitleAndDay(title, day);
        model.addAttribute("studyroom", studyroom);
        return "studyroom_day";
    }
}
