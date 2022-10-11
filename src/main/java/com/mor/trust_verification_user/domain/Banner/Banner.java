package com.mor.trust_verification_user.domain.Banner;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Table(name = "banner")
@Entity
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bannerId;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime bannerStartDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime bannerEndDate;

    @Column
    private String topFixed;

    @Column
    private String bannerStatus;

    @Column
    private String bannerTitle;

    @Column
    private String bannerImg;

    @Column
    private String bannerLink1;

    @Column
    private String bannerLink2;

    @Column
    private String contents;

    @Column
    private String bannerType;

    @Column
    private String imgName;

    @Column
    private String sessionType;

    @Column
    private Long createUserId;

    @Column
    private Long updateUserId;

    @CreatedDate
    private LocalDateTime createTime;

    @LastModifiedDate
    private LocalDateTime updateTime;

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
