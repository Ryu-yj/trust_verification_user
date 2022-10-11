package com.mor.trust_verification_user.service;


import com.mor.trust_verification_user.domain.Banner.Banner;
import com.mor.trust_verification_user.domain.Banner.BannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerService {

    @Autowired
    private BannerRepository bannerRepository;

//    @Autowired
//    private UserRepository userRepository;

    public List<Banner> getAllBanners() {
        return bannerRepository.findAllByBannerStatusAndSessionType("show", "MB");
    }

    public List<Banner> getAllMSI() {
        return bannerRepository.findAllByBannerStatusAndSessionType("show","MSI");
    }

    public List<Banner> getAllMSG() {
        return bannerRepository.findAllByBannerStatusAndSessionType("show","MSG");
    }

    public List<Banner> getAllMTNFT() {
        return bannerRepository.findAllByBannerStatusAndSessionType("show","MTNFT");
    }

    public List<Banner> getAllSSG() {
        return bannerRepository.findAllByBannerStatusAndSessionType("show","SSG");
    }

    public List<Banner> getAllSPG() {
        return bannerRepository.findAllByBannerStatusAndSessionType("show","SPG");
    }
//
//    public void insertBannerBoard(Banner banner, String loginId) {
//        if (banner != null) {
//            User user = userRepository.findByUserIdentification(loginId);
//            banner.setCreateUserId(user.getUserId());
//            bannerRepository.save(banner);
//        }
//    }
//
//    public int deleteBanner(Banner banner, String loginId) {
//        User user = userRepository.findByUserIdentification(loginId);
//        if (bannerRepository.findByBannerId(banner.getBannerId())!=null){
//            return bannerRepository.deleteBanner(banner.getBannerId(),user.getUserId());
//        }else {
//            return 0;
//        }
//
//    }
//
//    public Banner getOneBanner(Long bannerId) {
//        return bannerRepository.findByBannerId(bannerId);
//    }
//
//    public void modifyBannerBoard(Banner banner, String loginId) {
//        if (banner != null) {
//            Banner result = bannerRepository.findByBannerId(banner.getBannerId());
//            User user = userRepository.findByUserIdentification(loginId);
//            result.setBannerTitle(banner.getBannerTitle());
//            result.setBannerType(banner.getBannerType());
//            result.setBannerStartDate(banner.getBannerStartDate());
//            result.setBannerEndDate(banner.getBannerEndDate());
//            result.setContents(banner.getContents());
//            result.setBannerStatus(banner.getBannerStatus());
//            result.setTopFixed(banner.getTopFixed());
//            result.setBannerLink1(banner.getBannerLink1());
//            result.setBannerLink2(banner.getBannerLink2());
//            result.setUpdateUserId(user.getUserId());
//            bannerRepository.save(result);
//        }
//    }

}
