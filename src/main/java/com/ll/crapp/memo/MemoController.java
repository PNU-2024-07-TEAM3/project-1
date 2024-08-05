package com.ll.crapp.memo;

import com.ll.crapp.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.security.core.Authentication;

@Controller
public class MemoController {

    @Autowired
    private MemoService memoService;

    // 메모 작성 페이지로 이동
    @GetMapping("/studyroom/{title}/{day}/writememo")
    public String showWriteMemoPage(@PathVariable String title, @PathVariable int day, Model model) {
        Memo memo = new Memo();
        model.addAttribute("memo", memo);
        model.addAttribute("title", title);
        model.addAttribute("day", day);
        return "write_memo";
    }

    // 메모 저장 처리 후 해당 스터디룸 일차 페이지로 리디렉션
    @PostMapping("/studyroom/{title}/{day}/writememo")
    public String writeMemo(@PathVariable String title, @PathVariable int day, @ModelAttribute Memo memo, RedirectAttributes redirectAttributes) {
        try {
            memoService.save(memo);
            redirectAttributes.addFlashAttribute("successMessage", "Memo saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", e.getMessage());
        }
        return "redirect:/studyroom/" + title + "/" + day;
    }

    @GetMapping("/memos")
    public String listUserMemos(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        SiteUser siteUser = (SiteUser) authentication.getPrincipal();
        model.addAttribute("memos", memoService.getMemosByUser(siteUser));
        return "memo_list";
    }

}