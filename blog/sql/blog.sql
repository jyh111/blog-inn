SET NAMES utf8mb4;

CREATE TABLE IF NOT EXISTS `User`(
    `userId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(64) NOT NULL,
    `username` VARCHAR(16) NOT NULL,
    `userImg` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(32) DEFAULT '123456',
    `self_introduction` VARCHAR(1024) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Blog`(
    `blogId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `writer` INTEGER,
    `page_view` INTEGER DEFAULT 0,
    `classification` VARCHAR(64) DEFAULT '',
    `content` VARCHAR(8192) DEFAULT NULL,
    `title` VARCHAR(64) DEFAULT NULL,
    CONSTRAINT user_ref FOREIGN KEY(`writer`) REFERENCES `User`(userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Favor`(
    `userId` INTEGER,
    `blogId` INTEGER,
    `classification` VARCHAR(64) DEFAULT '',
    PRIMARY KEY (`userId`,`blogId`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Comment`(
    `commentId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `blogId` INTEGER,
    `content` VARCHAR(1024) DEFAULT NULL,
    `reviewer` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT blog_ref FOREIGN KEY (`blogId`) REFERENCES `Blog`(blogId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Message`(
    `commentId` INTEGER,
    `sender` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT comment_ref FOREIGN KEY(`commentId`) REFERENCES `Comment`(commentId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
