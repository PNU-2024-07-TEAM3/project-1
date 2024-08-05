package com.ll.crapp.memo;

import com.ll.crapp.user.SiteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

    public Memo save(Memo memo) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            SiteUser siteUser = (SiteUser) authentication.getPrincipal();
            // Check if the user has already written a memo
            List<Memo> existingMemo = memoRepository.findBySiteUser(siteUser);
            if (existingMemo.isEmpty()) {
                throw new Exception("You have already written a memo.");
            }

            memo.setSiteUser(siteUser);  // Set the user as the memo's author
            return memoRepository.save(memo);
        }
        throw new Exception("User not authenticated.");
    }

    public List<Memo> findByClassroomAndDayNo(Long classroomId, int dayNo) {
        return memoRepository.findByClassroomIdAndDayNo(classroomId, dayNo);
    }

    public List<Memo> getMemosByUser(SiteUser siteUser) {
        return memoRepository.findBySiteUser(siteUser);
    }
}
