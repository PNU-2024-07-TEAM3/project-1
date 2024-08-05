package com.ll.crapp.classroom;

import com.ll.crapp.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public List<Classroom> findAllBySiteUser(SiteUser siteUser) { return classroomRepository.findAllBySiteUser(siteUser);
    }
}
