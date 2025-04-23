DROP TABLE IF EXISTS `ORDER_COFFEE`;
DROP TABLE IF EXISTS `ORDER`;
DROP TABLE IF EXISTS `COFFEE`;
DROP TABLE IF EXISTS `MEMBER`;

-- 회원 테이블
CREATE TABLE `MEMBER` (
                          `EMAIL` VARCHAR(200) NOT NULL PRIMARY KEY comment '이메일',
                          `PASSWORD` VARCHAR(200) NOT NULL comment '비밀번호',
                          `PHONE` VARCHAR(50) NOT NULL comment '전화번호'
);

-- 커피 테이블
CREATE TABLE `COFFEE` (
                          `COFFEE_ID` INT NOT NULL PRIMARY KEY comment '제품번호',
                          `COFFEE_NAME` VARCHAR(200) NOT NULL comment '제품명',
                          `PRICE` INT NOT NULL comment '가격',
                          `TYPE` VARCHAR(20) comment '제품유형'
);

-- 주문 테이블
CREATE TABLE `ORDER` (
                         `ORDER_NO` INT NOT NULL auto_increment primary key comment '주문번호',
                         `EMAIL` VARCHAR(200) NOT NULL comment '이메일',
                         `ADDRESS` VARCHAR(200) NOT NULL comment '주소',
                         `POSTCODE` VARCHAR(200) NOT NULL comment '우편번호',
                         `ORDER_DATE` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP comment '주문시각',
                         `TOTAL_PRICE` INT comment '주문총액'
)AUTO_INCREMENT = 1000;

-- 주문 상품 내역 테이블
CREATE TABLE `ORDER_COFFEE` (
                                `ORDER_NO` INT NOT NULL comment '주문번호',
                                `COFFEE_ID` VARCHAR(100) NOT NULL comment '제품번호',
                                `COFFEE_NAME` VARCHAR(200) NOT NULL comment '제품명',
                                `QUANTITY` INT NOT NULL DEFAULT 0 comment '수량'
);