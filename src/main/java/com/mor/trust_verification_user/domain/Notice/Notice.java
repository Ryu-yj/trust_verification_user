package com.mor.trust_verification_user.domain.Notice;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "notice")
@Entity
public class Notice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column
    private String noticeTitle;

    @Column
    private String contents;

    @Column
    private Long createUserId;

    @Column
    private Long updateUserId;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column
    private String noticeStatus;

    @Column
    private String topFix;

//    @OneToOne
//    @JoinColumn(name = "createUserId",insertable = false,updatable = false)
//    @ToString.Exclude
//    private User createUser;
//
//    @OneToOne
//    @JoinColumn(name = "updateUserId",insertable = false,updatable = false)
//    @ToString.Exclude
//    private User updateUser;

}
