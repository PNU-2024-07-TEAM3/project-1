package com.ll.crapp.classup;

import com.ll.crapp.user.SiteUser;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private LocalDate endDate;

    private int memberCount;
    private boolean isOpen;

    @Column(nullable = false, length = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private SiteUser owner;
    public void decrementMemberCount() {
        if (this.memberCount > 0) {
            this.memberCount -= 1;  // 멤버 수 감소
        }
    }

    public void setOpen(boolean open) {
        this.isOpen = open;
    }

    // 추가적으로 필요한 getter와 setter
    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public SiteUser getOwner() {
        return owner;
    }
    public void setOwner(SiteUser owner) {
        this.owner = owner;
    }
}
