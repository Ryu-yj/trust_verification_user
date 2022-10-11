package com.mor.trust_verification_user.domain.Reference;

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
@Table(name = "reference")
@Entity
public class Reference {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referenceId;

    @Column
    private String referenceTitle;

    @Column
    private String contents;

    @Column
    private Long createUserId;

    @Column
    private Long updateUserId;

    @Column
    private String orgNm;

    @Column
    private String savedNm;

    @Column
    private String savedPath;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column
    private String referenceStatus;



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
