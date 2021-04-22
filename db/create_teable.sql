CREATE TABLE `board_info` (
  `board_info_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '게시판 아이디',
  `board_name` varchar(20) NOT NULL COMMENT '게시판 명(메뉴명)',
  `board_type` varchar(20) NOT NULL DEFAULT 'GENERAL' COMMENT '게시판 형식',
  `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0: 사용중, 1: 삭제됨',
  `created_by` varchar(20) NOT NULL COMMENT '생성자',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_by` varchar(20) NOT NULL COMMENT '변경자',
  `modified_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '변경일',
  PRIMARY KEY (`board_info_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

CREATE TABLE `board_post` (
  `board_post_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '게시글ID',
  `board_info_id` int(11) unsigned NOT NULL COMMENT '게시판 아이디',
  `category` varchar(20) NOT NULL COMMENT '게시판 카테고리',
  `title` varchar(1500) DEFAULT NULL COMMENT '제목',
  `contents` text COMMENT '내용',
  `hit` int(11) unsigned NOT NULL DEFAULT '0' COMMENT '조회수',
  `main_image_id` int(11) unsigned DEFAULT NULL COMMENT '대표이미지',
  `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0: 사용중, 1: 삭제됨',
  `created_by` varchar(20) NOT NULL COMMENT '생성자',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_by` varchar(20) NOT NULL COMMENT '변경자',
  `modified_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '변경일',
  PRIMARY KEY (`board_post_id`),
  KEY `board_post_idx_board_info_id` (`board_info_id`),
  KEY `board_post_idx_board_created_at` (`created_at`)
) ENGINE=InnoDB AUTO_INCREMENT=3513 DEFAULT CHARSET=utf8;

CREATE TABLE `board_file` (
  `board_file_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '파일ID',
  `board_post_id` int(11) unsigned NOT NULL COMMENT '게시글ID',
  `file_type` varchar(20) NOT NULL COMMENT '파일 타입',
  `file_path` varchar(100) NOT NULL COMMENT '파일경로',
  `file_original_name` varchar(100) DEFAULT NULL COMMENT '오리지널 파일명',
  `file_name` varchar(100) DEFAULT NULL COMMENT '파일명',
  `deleted` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '0: 사용중, 1: 삭제됨',
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일',
  `modified_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '변경일',
  PRIMARY KEY (`board_file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;