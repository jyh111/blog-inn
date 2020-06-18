SET NAMES utf8mb4;
DROP TABLE IF EXISTS `Favor`;
DROP TABLE IF EXISTS `Message`;
DROP TABLE IF EXISTS `Comment`;
DROP TABLE IF EXISTS `BlogFolder`;
DROP TABLE IF EXISTS `favorfolder`;
DROP TABLE IF EXISTS `Blog`;
DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`(
    `userId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(64) NOT NULL,
    `username` VARCHAR(16) NOT NULL,
    `userImg` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(32) DEFAULT '123456',
    `self_introduction` VARCHAR(1024) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `User` VALUES (1,'111@qq.com','测试一号','','123456','hello')

CREATE TABLE `Blog`(
    `blogId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `writer` INTEGER,
    `page_view` INTEGER DEFAULT 0,
    `classification` VARCHAR(64) DEFAULT '',
    `content` VARCHAR(8192) DEFAULT NULL,
    `title` VARCHAR(64) DEFAULT NULL,
    CONSTRAINT user_ref_from_blog FOREIGN KEY(`writer`) REFERENCES `User`(userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `FavorFolder`(
    `userId` INTEGER,
    `folder_name` VARCHAR(64) DEFAULT '',
    CONSTRAINT user_ref_from_favorFolder FOREIGN KEY (`userId`) REFERENCES `User`(userId)
)ENGINE = InnoDB DEFAULT CHARSET =utf8mb4;


CREATE TABLE `BlogFolder`(
         `userId` INTEGER,
        `folder_name` VARCHAR(64) DEFAULT '',
        CONSTRAINT user_ref_from_blogFolder FOREIGN KEY (`userId`) REFERENCES `User`(userId)
)ENGINE = InnoDB DEFAULT CHARSET =utf8mb4;


CREATE TABLE `Favor`(
    `userId` INTEGER,
    `blogId` INTEGER,
    `classification` VARCHAR(64) DEFAULT '',
    CONSTRAINT user_ref_from_favor FOREIGN KEY (`userId`) REFERENCES `User`(userId),
    CONSTRAINT blog_ref_from_favor FOREIGN KEY (`blogId`) REFERENCES `Blog`(blogId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `Comment`(
    `commentId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `blogId` INTEGER,
    `content` VARCHAR(1024) DEFAULT NULL,
    `reviewer` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT blog_ref_from_comment FOREIGN KEY (`blogId`) REFERENCES `Blog`(blogId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `Message`(
    `commentId` INTEGER,
    `sender` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT comment_ref_from_message FOREIGN KEY(`commentId`) REFERENCES `Comment`(commentId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
