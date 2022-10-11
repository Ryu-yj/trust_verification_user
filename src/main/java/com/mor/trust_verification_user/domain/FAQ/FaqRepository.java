package com.mor.trust_verification_user.domain.FAQ;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface FaqRepository extends JpaRepository<Faq, Long> {

    Page<Faq> findAllByFaqStatus(String show, Pageable pageable);

    Page<Faq> findAllByFaqStatusAndFaqTitleContaining(String show, String keyword, Pageable pageable);
}
