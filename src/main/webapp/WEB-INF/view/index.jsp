<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="access" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/assets/css/index.css">
<head>
    <title>쇼핑몰 - Welcome</title>
</head>
<body>
<div class="header-decoration"></div>
<div class="container">
    <h1>환영합니다! ✨ 쇼핑몰</h1>

    <p class="welcome-text">최신 트렌드 상품과 특별한 혜택이 당신을 기다립니다</p>
    <a href="member/member-login" class="login-btn">회원 주문하기</a>
    <a href="member/signup" class="login-btn">회원가입</a>
    <a href="member/guest-login" class="login-btn">비회원 주문하기</a>
</div>
</body>
</html>