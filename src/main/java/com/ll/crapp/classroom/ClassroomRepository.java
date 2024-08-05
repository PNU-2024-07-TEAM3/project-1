package com.ll.crapp.classroom;

import com.ll.crapp.user.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
    List<Classroom> findAllBySiteUser(SiteUser siteUser);
}
