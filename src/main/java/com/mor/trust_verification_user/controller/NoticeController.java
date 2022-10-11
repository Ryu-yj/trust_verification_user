package com.mor.trust_verification_user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mor.trust_verification_user.domain.Notice.Notice;
import com.mor.trust_verification_user.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.Model;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Api(tags = "공지사항")
@RestController
@RequestMapping(value = "/notice")
public class NoticeController {

    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {this.noticeService = noticeService;}

    @ApiOperation(value = "공지사항 리스트 조회")
    @GetMapping(value = "/get_notice_list")
    public ModelAndView getNoticeList(HttpServletRequest request,
                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("notice");
        Page<Notice> topFix = noticeService.getAllTopFix(page);
        Page<Notice> notices = noticeService.getAllNotices(page);
        mav.addObject("paging",notices);
        mav.addObject("topFix", topFix);
        mav.addObject("msg",msg);
        return mav;
    }


    @ApiOperation(value = "공지사항 상세보기")
    @GetMapping(value = "/get_notice_detail")
    public ModelAndView getNoticeView(HttpServletRequest request, Notice notice,
                                      @RequestParam(value = "page", defaultValue = "0") int page,
                                      @RequestParam(value = "page", defaultValue = "0") String msg) {
        ModelAndView mav = new ModelAndView("views_notice");
        Page<Notice> topFix = noticeService.getTopFixView(page, notice.getNoticeId());
        Page<Notice> paging = noticeService.getAllNoticeId(page, notice.getNoticeId());
        mav.addObject("paging", paging);
        mav.addObject("topFix", topFix);
        mav.addObject("msg", msg);
        return mav;
    }


    @ApiOperation(value = "공지사항 검색")
    @GetMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request, Notice notice,
                               @RequestParam(value = "keyword") String keyword,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("notice");
        Page<Notice> paging = noticeService.getsearch(page, keyword);
        //Page<Notice> topFix = noticeService.getsearchNofix(page, keyword);
        mav.addObject("paging", paging);
        //mav.addObject("topFix", topFix);
        mav.addObject("msg", msg);
        return mav;
    }


}
