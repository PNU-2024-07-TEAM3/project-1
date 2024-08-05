package com.ll.crapp.memo;

import com.ll.crapp.user.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Memo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Long classroomId;// 연관 클래스룸의 ID
    private Integer dayNo;

    @ManyToOne(fetch = FetchType.LAZY)
    private SiteUser siteUser;  // 메모를 작성한 사용자
}
