package com.ll.crapp.classup;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ClassupRepository extends JpaRepository<Classup, Long> {
    Optional<Classup> findByTitle(String title);
}