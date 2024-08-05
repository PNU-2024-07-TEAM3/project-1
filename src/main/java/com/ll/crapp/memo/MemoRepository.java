package com.ll.crapp.memo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ll.crapp.user.SiteUser;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    List<Memo> findByClassroomIdAndDay(Long classroomId, int day);
    List<Memo> findBySiteUser(SiteUser siteUser);
}
