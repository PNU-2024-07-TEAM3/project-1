package com.ll.crapp.classroom;

import com.ll.crapp.user.SiteUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClassroomController {

    private final ClassroomService classroomService;

    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    @GetMapping("/classroom")
    public String classroomPage() {
        return "classroom_set";
    }

    @GetMapping("/myclassroom/list")
    public String myClassroom(Model model, Authentication authentication) {
        SiteUser siteUser = (SiteUser) authentication.getPrincipal();
        List<Classroom> classrooms = classroomService.findAllBySiteUser(siteUser);
        model.addAttribute("classrooms", classrooms);
        return "myclassroom_list";
    }

}
