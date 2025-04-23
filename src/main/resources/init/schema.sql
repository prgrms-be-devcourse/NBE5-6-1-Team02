DROP TABLE IF EXISTS `MEMBER`;

CREATE TABLE `MEMBER`
(
    `USER_Email`    VARCHAR(36) PRIMARY KEY COMMENT '회원 이메일',
    `PASSWORD`   VARCHAR(70) NOT NULL COMMENT '회원 비밀번호',
    `ROLE`      CHAR(50)    NULL     DEFAULT 'ROLE_USER' COMMENT '회원 등급',
    `TEL`        VARCHAR(15) NULL COMMENT '회원 전화번호',
    `ADDRESS`   VARCHAR(15) NULL COMMENT '회원 주소',
    `ZIPCODE`   VARCHAR(10)  NULL COMMENT '회원 우편 번호',
    `ACTIVATED`  bool        NOT NULL DEFAULT true COMMENT '활성여부'
);


DROP TABLE IF EXISTS `MEMBER_INFO`;

CREATE TABLE `MEMBER_INFO`
(
    `USER_ID`       VARCHAR(36) PRIMARY KEY COMMENT '회원 아이디',
    `CREATED_AT`    timestamp NULL DEFAULT now() COMMENT '가입일자',
    `LOGIN_DATE`    timestamp NULL COMMENT '마지막로그인일자',
    `MODIFY_DATE`   timestamp NULL COMMENT '마지막수정일자',
    `LEAVE_DATE`    timestamp NULL COMMENT '탈퇴일자',
    `RENTABLE_DATE` timestamp NULL DEFAULT now() COMMENT '대출가능일자'
);


DROP TABLE IF EXISTS `ORDERCOFFEE`;
DROP TABLE IF EXISTS `ORDER`;
DROP TABLE IF EXISTS `COFFEE`;
DROP TABLE IF EXISTS `MEMBER`;

-- 회원 테이블
CREATE TABLE `MEMBER` (
                          `EMAIL` VARCHAR(200) NOT NULL PRIMARY KEY,
                          `PASSWORD` VARCHAR(200) NOT NULL,
                          `PHONE` VARCHAR(50) NOT NULL
);

-- 커피 테이블
CREATE TABLE `COFFEE` (
                          `COFFEE_ID` INT NOT NULL PRIMARY KEY,
                          `COFFEE_NAME` VARCHAR(200) NOT NULL,
                          `PRICE` INT NOT NULL
);

-- 주문 테이블
CREATE TABLE `ORDER` (
                         `ORDER_NO` INT ,
                         `EMAIL` VARCHAR(200) NOT NULL,
                         `ADDRESS` VARCHAR(200) NOT NULL,
                         `ORDER_DATE` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP

);

-- 주문 상품 내역 테이블
CREATE TABLE `ORDERCOFFEE` (
                               `ORDER_NO` INT NOT NULL NOT NULL AUTO_INCREMENT PRIMARY KEY,
                               `COFFEE_ID` VARCHAR(100) NOT NULL,
                               `COFFEE_NAME` VARCHAR(200) NOT NULL ,
                               `COUNT` INT NOT NULL DEFAULT 0

)AUTO_INCREMENT = 1000;



