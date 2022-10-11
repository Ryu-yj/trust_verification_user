package com.mor.trust_verification_user.controller;

import com.mor.trust_verification_user.domain.FAQ.Faq;
import com.mor.trust_verification_user.service.FaqService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "FAQ 자주 묻는 질문")
@RestController
@RequestMapping(value = "/faq")
public class FaqController {

    private final FaqService faqService;

    public FaqController(FaqService faqService) {this.faqService = faqService;}

    @ApiOperation(value = "faq 리스트 조회")
    @GetMapping(value = "/get_faq_list")
    public ModelAndView getFaqList(HttpServletRequest request,
                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("faq");
        Page<Faq> faq = faqService.getAllFaqs(page);
        mav.addObject("paging",faq);
        mav.addObject("msg",msg);
        return mav;
    }


    @ApiOperation(value = "faq 검색")
    @GetMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request, Faq faq,
                               @RequestParam(value = "keyword") String keyword,
                               @RequestParam(value = "page", defaultValue = "0") int page,
                               @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("faq");
        Page<Faq> paging = faqService.getsearch(page, keyword);
        mav.addObject("paging", paging);
        return mav;
    }


}
