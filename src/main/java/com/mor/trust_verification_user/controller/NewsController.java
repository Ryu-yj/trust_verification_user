package com.mor.trust_verification_user.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.mor.trust_verification_user.domain.News.News;
import com.mor.trust_verification_user.service.NewsService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Api(tags = "뉴스/홍보 게시판")
@RestController
@RequestMapping(value = "/news")
public class NewsController {

    private final NewsService newsService;

    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @ApiOperation(value = "뉴스/홍보 리스트 조회 - 전체")
    @GetMapping(value = "/get_news_list")
    public ModelAndView getNewsList(HttpServletRequest request,
                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("news");
        Page<News> news = newsService.getAllNews(page);
        mav.addObject("paging",news);
        mav.addObject("msg",msg);
        mav.addObject("category", "all");
        return mav;
    }

    @ApiOperation(value = "뉴스/홍보 리스트 조회-뉴스")
    @GetMapping(value = "/get_news_list_news")
    public ModelAndView getNewsNewsList(HttpServletRequest request,
                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("news");
        Page<News> news = newsService.getAllNewsNews(page);
        mav.addObject("paging",news);
        mav.addObject("msg",msg);
        mav.addObject("category", "news");
        return mav;
    }

    @ApiOperation(value = "뉴스/홍보 리스트 조회-홍보")
    @GetMapping(value = "/get_news_list_promotion")
    public ModelAndView getNewsPromotionList(HttpServletRequest request,
                                    @RequestParam(value = "page", defaultValue = "0") int page,
                                    @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("news");
        Page<News> news = newsService.getAllNewsPromotion(page);
        mav.addObject("paging",news);
        mav.addObject("msg",msg);
        mav.addObject("category", "promotion");
        return mav;
    }

    @ApiOperation(value = "뉴스/홍보 상세보기")
    @GetMapping(value = "/get_news_detail")
    public ModelAndView getNewsView(HttpServletRequest request, News news,
                                             @RequestParam(value = "page", defaultValue = "0") int page,
                                             @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("views_news");
        Page<News> paging = newsService.getAllNewsId(page,news.getNewsId());
        mav.addObject("paging",paging);
        mav.addObject("msg",msg);
        mav.addObject("category", "all");

//        List<News> detail = new ArrayList<>();
//
//        for (News n:paging) {
//            System.out.println("news+++"+n);
//            if (n.getNewsId() == news.getNewsId()){
//                detail.add(n);
//                System.out.println("paging.getNumber() : "+paging.getNumber());
//            }
//        }
//        mav.addObject("detail",detail);
        return mav;
    }


    @ApiOperation(value = "공지사항 검색")
    @GetMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request, News news,
                               @RequestParam(value = "keyword") String keyword,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("views_news");
        Page<News> paging = newsService.getsearch(page, keyword);
        mav.addObject("paging", paging);
        mav.addObject("msg", msg);
        return mav;
    }



}
