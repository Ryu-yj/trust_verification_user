package com.mor.trust_verification_user.domain.News;

import com.mor.trust_verification_user.domain.Notice.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface NewsRepository extends JpaRepository<News, Long> {

//    String deleteQuery = "update news set update_user_id = ?2  where news = ?1";
//
//    News findByNewsId(Long newsId);
//
//    @Query(value = deleteQuery, nativeQuery = true)
//    @Modifying
//    @Transactional
//    int deleteNews(Long newsId, Long newsId1);

    Page<News> findAllByNewsStatus(String show, Pageable pageable);

    Page<News> findAllByNewsStatusAndNewsType(String show, String promotion, Pageable pageable);

    Page<News> findAllByNewsStatusAndNewsId(String show, Long newsId, Pageable pageable);

    Page<News> findAllByNewsStatusAndNewsTitleContaining(String show, String keyword, Pageable pageable);


//    String seleteQuery = "select * set news where id=?";
//
//    @Query(value = seleteQuery, nativeQuery = true)
//    @Modifying
//    @Transactional
//    int seleteNews(Long news_id);

//    Page<News> findAllByNewsStatus(String show, Pageable pageable);


}
