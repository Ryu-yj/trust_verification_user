package com.mor.trust_verification_user.service;


import com.mor.trust_verification_user.domain.News.News;
import com.mor.trust_verification_user.domain.News.NewsRepository;
import com.mor.trust_verification_user.domain.Notice.Notice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NewsService {

    @Autowired
    private NewsRepository newsRepository;

    public Page<News> getAllNews(int page) {
        Pageable pageable = PageRequest.of(page, 12, Sort.Direction.DESC, "newsId");
        return newsRepository.findAllByNewsStatus("show",pageable);
    }

    public Page<News> getAllNewsNews(int page) {
        Pageable pageable = PageRequest.of(page, 12, Sort.Direction.DESC, "newsId");
        return newsRepository.findAllByNewsStatusAndNewsType("show", "news",pageable);
    }

    public Page<News> getAllNewsPromotion(int page) {
        Pageable pageable = PageRequest.of(page, 12, Sort.Direction.DESC, "newsId");
        return newsRepository.findAllByNewsStatusAndNewsType("show", "promotion", pageable);
    }


    public Page<News> getAllNewsId(int page, Long newsId) {
        Pageable pageable = PageRequest.of(page, 1, Sort.Direction.DESC, "newsId");
        return newsRepository.findAllByNewsStatusAndNewsId("show", newsId, pageable);
    }


    public Page<News> getsearch(int page, String keyword) {
        Pageable pageable = PageRequest.of(page, 10, Sort.Direction.DESC, "newsId");
        return newsRepository.findAllByNewsStatusAndNewsTitleContaining("show", keyword, pageable);
    }
}
