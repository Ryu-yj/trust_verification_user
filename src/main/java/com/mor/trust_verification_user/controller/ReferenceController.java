package com.mor.trust_verification_user.controller;

import com.mor.trust_verification_user.domain.Reference.Reference;
import com.mor.trust_verification_user.domain.Reference.ReferenceRepository;
import com.mor.trust_verification_user.service.ReferenceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;

@Api(tags = "자료실")
@RestController
@RequestMapping(value = "/reference")
public class ReferenceController {

    private final ReferenceService referenceService;

    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @ApiOperation(value = "자료실 리스트 조회")
    @GetMapping(value = "/get_reference_list")
    public ModelAndView getReferenceList(HttpServletRequest request,
                                   @RequestParam(value = "page", defaultValue = "0") int page,
                                   @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("reference");
        Page<Reference> reference = referenceService.getAllReferences(page);
        mav.addObject("paging",reference);
        mav.addObject("msg",msg);
        return mav;
    }

    @ApiOperation(value = "자료실 상세 조회")
    @GetMapping(value = "/get_reference_detail")
    public ModelAndView getReferenceView(HttpServletRequest request, Reference reference,
                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("views_reference");
        Page<Reference> paging = referenceService.getReferenceId(page, reference.getReferenceId());
        mav.addObject("paging", paging);
        mav.addObject("msg", msg);
        return mav;
    }

    @ApiOperation(value = "자료실 검색")
    @GetMapping(value = "/search")
    public ModelAndView search(HttpServletRequest request, Reference reference,
                                         @RequestParam(value = "keyword") String keyword,
                                         @RequestParam(value = "page", defaultValue = "0") int page,
                                         @RequestParam(value = "msg", defaultValue = "null") String msg) {
        ModelAndView mav = new ModelAndView("reference");
        Page<Reference> paging = referenceService.getsearch(page, keyword);
        mav.addObject("paging", paging);
        return mav;
    }


//    @GetMapping("/attach/{referenceId}")
//    public ResponseEntity<UrlResource> downloadAttach(@PathVariable Long referenceId) throws MalformedURLException {
//
//        Reference file = (Reference) ReferenceRepository.findAllByreferenceId(referenceId).orElse(null);
//
//        UrlResource resource = new UrlResource("file:" + file.getSavedPath());
//
//        String encodedFileName = UriUtils.encode(file.getOrgNm(), StandardCharsets.UTF_8);
//
//        // 파일 다운로드 대화상자가 뜨도록 하는 헤더를 설정해주는 것
//        // Content-Disposition 헤더에 attachment; filename="업로드 파일명" 값을 준다.
//        String contentDisposition = "attachment; filename=\"" + encodedFileName + "\"";
//
//        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,contentDisposition).body(resource);
//    }



}
