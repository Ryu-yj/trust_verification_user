package com.mor.trust_verification_user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    //web root가 아닌 외부 경로에 있는 리소스를 url로 불러올 수 있도록 설정
    //현재 localhost:8090/summernoteImage/1234.jpg
    //로 접속하면 C:/summernote_image/1234.jpg 파일을 불러온다.

    @Value("${banner.image.path}")
    private String bannerImagePath;

    @Value("${faq.image.path}")
    private String faqImagePath;

    @Value("${news.image.path}")
    private String newsImagePath;

    @Value("${notice.image.path}")
    private String noticeImagePath;

    @Value("${reference.image.path}")
    private String referenceImagePath;

    @Value("${banner.image.path.set}")
    private String bannerImagePathSet;

    @Value("${faq.image.path.set}")
    private String faqImagePathSet;

    @Value("${news.image.path.set}")
    private String newsImagePathSet;

    @Value("${notice.image.path.set}")
    private String noticeImagePathSet;

    @Value("${reference.image.path.set}")
    private String referenceImagePathSet;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(bannerImagePath,
                        faqImagePath,
                        newsImagePath,
                        noticeImagePath,
                        referenceImagePath)
                .addResourceLocations(bannerImagePathSet)
                .addResourceLocations(faqImagePathSet)
                .addResourceLocations(newsImagePathSet)
                .addResourceLocations(noticeImagePathSet)
                .addResourceLocations(referenceImagePathSet);


    }
}