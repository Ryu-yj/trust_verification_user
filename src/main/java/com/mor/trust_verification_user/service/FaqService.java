package com.mor.trust_verification_user.service;

import com.mor.trust_verification_user.domain.FAQ.Faq;
import com.mor.trust_verification_user.domain.FAQ.FaqRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class FaqService {

    @Autowired
    private FaqRepository faqRepository;

//    @Autowired
//    private UserRepository userRepository;

    public Page<Faq> getAllFaqs(int page) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "faqId");
        return faqRepository.findAllByFaqStatus("show",pageable);
    }

    public Page<Faq> getsearch(int page, String keyword) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "faqId");
        return faqRepository.findAllByFaqStatusAndFaqTitleContaining("show", keyword, pageable);
    }

//    public void insertFaqBoard(Faq faq, String loginId) {
//        if (faq != null) {
//            User user = userRepository.findByUserIdentification(loginId);
//            faq.setCreateUserId(user.getUserId());
//            faqRepository.save(faq);
//        }
//    }
//
//    public int deleteFaq(Faq faq, String loginId) {
//        User user = userRepository.findByUserIdentification(loginId);
//        if (faqRepository.findByFaqId(faq.getFaqId())!=null) {
//            return faqRepository.deleteFaq(faq.getFaqId(),user.getUserId());
//        } else {
//            return 0;
//        }
//    }
//
//    public Faq getOneFaq(Long faqId) {
//        return faqRepository.findByFaqId(faqId);
//    }
//
//    public void modifyFaqBoard(Faq faq, String loginId) {
//        if (faq != null) {
//            Faq result = faqRepository.findByFaqId(faq.getFaqId());
//            User user = userRepository.findByUserIdentification(loginId);
//            result.setFaqTitle(faq.getFaqTitle());
//            result.setContents(faq.getContents());
//            result.setUpdateUserId(user.getUserId());
//            faqRepository.save(result);
//        }
//    }
}
