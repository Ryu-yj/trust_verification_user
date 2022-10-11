package com.mor.trust_verification_user.domain.Notice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

//    String deleteQuery = "update notice set update_user_id = ?2  where notice_id = ?1";
//
//    @Query(value = deleteQuery, nativeQuery = true)
//    @Modifying
//    @Transactional
//    int deleteNotice(Long noticeId, Long userId);
//
//    Notice findByNoticeId(Long noticeId);

    Page<Notice> findAllByNoticeStatusAndTopFix(String show, String fix, Pageable pageable);

    Page<Notice> findAllByNoticeStatusAndNoticeId(String show, Long noticeId, Pageable pageable);

    Page<Notice> findAllByNoticeStatusAndNoticeTitleContaining(String show ,String keyword, Pageable pageable);

    Page<Notice> findAllByNoticeStatus(String show, Pageable pageable);
}
