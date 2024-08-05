package com.ll.crapp.classup;

import com.ll.crapp.user.SiteUser;
import com.ll.crapp.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ClassupController {
    private final ClassupService classupService;
    private final UserService userService;

    @GetMapping("/classup/list")
    public String showClassupList(Model model) {
        model.addAttribute("classups", classupService.findAll());
        return "classup_list";
    }

    @GetMapping("/classup/post")
    public String showClassupPostForm() {
        return "classup_post";
    }

    @PostMapping("/classup/post")
    public String postClassup(Classup classup) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SiteUser siteUser = userService.findByUsername(userDetails.getUsername());
        classup.setOwner(siteUser);
        classupService.save(classup);
        return "redirect:/classup/list";
    }

    @GetMapping("/classup/{title}")
    public String classupDetails(@PathVariable String title, Model model, Authentication authentication) {
        Classup classup = classupService.findByTitle(title)
                .orElseThrow(() -> new IllegalArgumentException("Invalid class title: " + title));
        SiteUser currentSiteUser = (SiteUser) authentication.getPrincipal();

        boolean isOwner = currentSiteUser.getUsername().equals(classup.getOwner().getUsername());
        model.addAttribute("classup", classup);
        model.addAttribute("isOwner", isOwner);

        return "classup_details";
    }

    @PostMapping("/classup/enroll/{title}")
    public String enrollInClassup(@PathVariable String title) {
        classupService.enroll(title);
        return "redirect:/classup/{title}";
    }

    @PostMapping("/classup/open/{title}")
    public String openClassroom(@PathVariable String title) {
        classupService.openClassroom(title);
        return "redirect:/myclassroom/";
    }
}
