package com.mor.trust_verification_user.domain.News;

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
@Table(name = "news")
@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long newsId;

    @Column
    private String newsTitle;

    @Column
    private String contents;

    @Column
    private String newsType;

    @Column
    private Long createUserId;

    @Column
    private Long updateUserId;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

    @Column
    private String newsStatus;

    @Column
    private String imagePath;

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
