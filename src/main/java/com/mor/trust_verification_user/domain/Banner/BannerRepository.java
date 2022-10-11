package com.mor.trust_verification_user.domain.Banner;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface BannerRepository extends JpaRepository<Banner, Long> {


//    String deleteQuery = "update banner set banner_status = 'noshow', update_user_id = ?2  where banner_id = ?1";
//    @Query(value = deleteQuery, nativeQuery = true)
//    @Modifying
//    @Transactional
//    int deleteBanner(Long banner_id, Long loginId);
//
//    Banner findByBannerId(Long bannerId);

    List<Banner> findAllByBannerStatus(String show);

    List<Banner> findAllByBannerStatusAndSessionType(String show, String mainServiceIntroduce);
}
