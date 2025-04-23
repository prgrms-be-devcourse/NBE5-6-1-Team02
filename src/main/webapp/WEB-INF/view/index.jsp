<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="access" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>쇼핑몰 - Welcome</title>
    <style>
      body {
        font-family: 'Segoe UI', Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
        color: #333;
      }

      .container {
        max-width: 1200px;
        margin: 0 auto;
        padding: 20px;
        text-align: center;
      }

      h1 {
        color: #2c3e50;
        font-size: 2.5em;
        margin: 40px 0;
        text-shadow: 2px 2px 4px rgba(0,0,0,0.1);
      }

      .welcome-text {
        font-size: 1.2em;
        color: #666;
        margin-bottom: 30px;
      }

      .login-btn {
        display: inline-block;
        padding: 12px 30px;
        background-color: #3498db;
        color: white;
        text-decoration: none;
        border-radius: 25px;
        font-size: 1.1em;
        transition: all 0.3s ease;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1);
      }

      .login-btn:hover {
        background-color: #2980b9;
        transform: translateY(-2px);
        box-shadow: 0 6px 12px rgba(0,0,0,0.15);
      }

      .header-decoration {
        background: linear-gradient(135deg, #3498db, #9b59b6);
        height: 150px;
        border-radius: 0 0 50% 50%;
        margin-bottom: 30px;
      }
    </style>
</head>
<body>
<div class="header-decoration"></div>
<div class="container">
    <h1>환영합니다! ✨ 쇼핑몰</h1>
    <p class="welcome-text">최신 트렌드 상품과 특별한 혜택이 당신을 기다립니다</p>
    <a href="member/member-login" class="login-btn">회원 주문하기</a>
    <a href="member/signup" class="login-btn">회원가입</a>
    <a href="member/guest-login" class="login-btn">비회원 주문하기</a>
    <sec:authorize access="isAuthenticated()">
        <a href="member/mypage" class="login-btn">마이페이지</a>
    </sec:authorize>
</div>
</body>
</html>