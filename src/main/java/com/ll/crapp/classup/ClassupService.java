package com.ll.crapp.classup;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassupService {
    private final ClassupRepository classupRepository;

    public Classup save(Classup classup) {
        return classupRepository.save(classup);
    }

    public List<Classup> findAll() {
        return classupRepository.findAll();
    }

    public Optional<Classup> findByTitle(String title) {
        return classupRepository.findByTitle(title);
    }

    public void enroll(String title) {
        Classup classup = findByTitle(title).orElseThrow(() -> new IllegalArgumentException("Classup not found"));
        classup.decrementMemberCount();
        if (classup.getMemberCount() <= 0) {
            classup.setOpen(true);
        }
        classupRepository.save(classup);
    }

    public void openClassroom(String title) {
        Classup classup = findByTitle(title).orElseThrow(() -> new IllegalArgumentException("Classup not found"));
        classup.setOpen(true);
        classupRepository.save(classup);
    }
}
