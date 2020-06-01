SET NAMES utf8mb4;

CREATE TABLE IF NOT EXISTS `User`(
    `userID` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(64) NOT NULL,
    `username` VARCHAR(16) NOT NULL,
    `userImg` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(32) DEFAULT '123456',
    `self_introduction` VARCHAR(1024) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Blog`(
    `blogID` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `writer` INTEGER,
    `page_view` INTEGER DEFAULT 0,
    `classification` VARCHAR(64) DEFAULT NULL,
    `content` VARCHAR(8192) DEFAULT NULL,
    CONSTRAINT user_ref FOREIGN KEY(`writer`) REFERENCES `User`(userID) ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Favor`(
    `userID` INTEGER,
    `blogID` INTEGER,
    PRIMARY KEY (`userID`,`blogID`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Comment`(
    `commentID` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `content` VARCHAR(1024) DEFAULT NULL,
    `reviewer` INTEGER,
    `recipient` INTEGER
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `Message`(
    `commentID` INTEGER,
    `sender` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT comment_ref FOREIGN KEY(`commentID`) REFERENCES `Comment`(commentID) ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
