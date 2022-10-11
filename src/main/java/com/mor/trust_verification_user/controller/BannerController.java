package com.mor.trust_verification_user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mor.trust_verification_user.domain.Banner.Banner;
import com.mor.trust_verification_user.domain.Reference.Reference;
import com.mor.trust_verification_user.service.BannerService;
import com.mor.trust_verification_user.service.ReferenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Api(tags = "배너")
@RestController
@RequestMapping(value = "/main")
public class BannerController {

    private final BannerService bannerService;

    public BannerController(BannerService bannerService) {
        this.bannerService = bannerService;
    }


    @ApiOperation(value = "메인 리스트 조회")
    @GetMapping(value = "/get_banner_list")
    public ModelAndView getBannerList(HttpServletRequest request,
                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "msg", defaultValue = "null") String msg){
        ModelAndView mav = new ModelAndView("main");
        List<Banner> banner = bannerService.getAllBanners();
        List<Banner> MSI = bannerService.getAllMSI();
        List<Banner> MSGu = bannerService.getAllMSG();
        List<Banner> MTNFT = bannerService.getAllMTNFT();
        System.out.println(banner);
        mav.addObject("msg",msg);
        mav.addObject("banner",banner);
        mav.addObject("MSI", MSI);
        mav.addObject("MSGu", MSGu);
        mav.addObject("MTNFT", MTNFT);
        return mav;
    }

    @ApiOperation(value = "메인 리스트 조회")
    @GetMapping(value = "/get_pguide_view")
    public ModelAndView getPGuideView(HttpServletRequest request,
                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "msg", defaultValue = "null") String msg){
        ModelAndView mav = new ModelAndView("partners_guide");
        List<Banner> SPG = bannerService.getAllSPG();
        System.out.println(SPG);
        mav.addObject("SPG", SPG);
        return mav;
    }


    @ApiOperation(value = "메인 리스트 조회")
    @GetMapping(value = "/get_sguide_view")
    public ModelAndView getSGuideView(HttpServletRequest request,
                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "msg", defaultValue = "null") String msg){
        ModelAndView mav = new ModelAndView("service_guide");
        List<Banner> SSG = bannerService.getAllSSG();
        System.out.println(SSG);
        mav.addObject("SSG", SSG);
        return mav;
    }


    @ApiOperation(value = "협력사 안내 페이지 이동")
    @ApiImplicitParams({@ApiImplicitParam(name = "admin", value = "배너", required = true, dataType = "Long", paramType = "query")})
    @GetMapping(value = "/search")
    public ModelAndView search(@RequestParam(value = "msg", defaultValue = "") String msg) {
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("msg",msg);
        return mav;
    }


}