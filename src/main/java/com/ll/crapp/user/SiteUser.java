package com.ll.crapp.user;

import com.ll.crapp.studyroom.StudyRoom;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String nickname;

    @ManyToMany
    @JoinTable(
            name = "user_study",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "study_id")
    )
    private Set<StudyRoom> studies = new HashSet<>();

}