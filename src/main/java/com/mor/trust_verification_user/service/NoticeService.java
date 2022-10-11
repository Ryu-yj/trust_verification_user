package com.mor.trust_verification_user.service;


import com.mor.trust_verification_user.domain.Notice.Notice;
import com.mor.trust_verification_user.domain.Notice.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

//    @Autowired
//    private UserRepository userRepository;

    public Page<Notice> getAllNotices(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "noticeId");
        return noticeRepository.findAllByNoticeStatus("show", pageable);
    }

    public Page<Notice> getAllTopFix(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "noticeId");
        return noticeRepository.findAllByNoticeStatusAndTopFix("show", "fix", pageable);
    }

    public Page<Notice> getAllNoticeId(int page, Long noticeId) {
        Pageable pageable = PageRequest.of(page, 1, Sort.Direction.DESC, "noticeId");
        return noticeRepository.findAllByNoticeStatusAndNoticeId("show", noticeId, pageable);
    }

    public Page<Notice> getTopFixView(int page, Long noticeId) {
        Pageable pageable = PageRequest.of(page, 1, Sort.Direction.DESC, "noticeId");
        return noticeRepository.findAllByNoticeStatusAndNoticeId("show", noticeId, pageable);
    }

    public Page<Notice> getsearch(int page, String keyword) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "noticeId");
        return noticeRepository.findAllByNoticeStatusAndNoticeTitleContaining("show", keyword, pageable);
    }
}
