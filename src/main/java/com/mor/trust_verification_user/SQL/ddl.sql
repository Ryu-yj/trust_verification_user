--faq 자주묻는질문
CREATE TABLE trust_veri.faq (
                                `faq_id` bigint(20) auto_increment NOT NULL COMMENT '글번호 (1부터 시작)',
                                `faq_title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT 'faq 제목',
                                `contents` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT 'faq 내용',
                                `create_user_id` int(11) DEFAULT NULL NULL COMMENT '생성자',
                                `update_user_id` int(11) DEFAULT NULL NULL COMMENT '수정자',
                                `create_time` datetime DEFAULT current_timestamp() NULL COMMENT '생성일자',
                                `update_time` datetime DEFAULT current_timestamp() on update current_timestamp() NULL COMMENT '수정일자',
                                PRIMARY KEY (`faq_id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='FAQ 자주 묻는 질문';


--reference 자료실
CREATE TABLE trust_veri.reference (
                                `reference_id` bigint(20) auto_increment NOT NULL COMMENT '글번호 (1부터 시작)',
                                `reference_title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '자료실 제목',
                                `contents` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '자료실 내용',
                                `create_user_id` int(11) DEFAULT NULL NULL COMMENT '생성자',
                                `update_user_id` int(11) DEFAULT NULL NULL COMMENT '수정자',
                                `create_time` datetime DEFAULT current_timestamp() NULL COMMENT '생성일자',
                                `update_time` datetime DEFAULT current_timestamp() on update current_timestamp() NULL COMMENT '수정일자',
                                PRIMARY KEY (`reference_id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='자료실';

--notice 공지사항
CREATE TABLE trust_veri.notice (
                                      `notice_id` bigint(20) auto_increment NOT NULL COMMENT '글번호 (1부터 시작)',
                                      `notice_title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '공지사항 제목',
                                      `contents` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '공지사항 내용',
                                      `create_user_id` int(11) DEFAULT NULL NULL COMMENT '생성자',
                                      `update_user_id` int(11) DEFAULT NULL NULL COMMENT '수정자',
                                      `create_time` datetime DEFAULT current_timestamp() NULL COMMENT '생성일자',
                                      `update_time` datetime DEFAULT current_timestamp() on update current_timestamp() NULL COMMENT '수정일자',
                                      PRIMARY KEY (`notice_id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='공지사항';

--news 뉴스/홍보
CREATE TABLE trust_veri.news (
                                   `news_id` bigint(20) auto_increment NOT NULL COMMENT '글번호 (1부터 시작)',
                                   `news_title` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '뉴스/홍보 제목',
                                   `contents` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '뉴스/홍보 내용',
                                   `news_type` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL NULL COMMENT '뉴스/홍보 타입',
                                   `create_user_id` int(11) DEFAULT NULL NULL COMMENT '생성자',
                                   `update_user_id` int(11) DEFAULT NULL NULL COMMENT '수정자',
                                   `create_time` datetime DEFAULT current_timestamp() NULL COMMENT '생성일자',
                                   `update_time` datetime DEFAULT current_timestamp() on update current_timestamp() NULL COMMENT '수정일자',
                                   PRIMARY KEY (`notice_id`)
)
    ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_general_ci
COMMENT='뉴스/홍보';
