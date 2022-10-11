package com.mor.trust_verification_user.domain.FAQ;

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
@Table(name = "faq")
@Entity
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long faqId;

    @Column
    private String faqTitle;

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
    private String faqStatus;

    @Column
    private String category;



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
