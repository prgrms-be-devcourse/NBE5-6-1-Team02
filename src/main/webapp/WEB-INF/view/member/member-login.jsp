<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>쇼핑몰 - 로그인</title>
    <style>
      body {
        font-family: 'Segoe UI', Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f5f5f5;
        color: #333;
        display: flex;
        justify-content: center;
        align-items: center;
        min-height: 100vh;
      }

      .login-container {
        background: white;
        padding: 40px;
        border-radius: 15px;
        box-shadow: 0 4px 15px rgba(0,0,0,0.1);
        width: 100%;
        max-width: 400px;
      }

      .header-decoration {
        background: linear-gradient(135deg, #3498db, #9b59b6);
        height: 100px;
        border-radius: 15px 15px 0 0;
        margin: -40px -40px 30px -40px;
      }

      h2 {
        color: #2c3e50;
        text-align: center;
        margin-bottom: 30px;
        font-size: 1.8em;
      }

      .form-group {
        margin-bottom: 20px;
        text-align: left;
      }

      label {
        display: block;
        margin-bottom: 5px;
        color: #666;
      }

      input[type="text"],
      input[type="password"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 1em;
        box-sizing: border-box;
        transition: border-color 0.3s ease;
      }

      input[type="text"]:focus,
      input[type="password"]:focus {
        border-color: #3498db;
        outline: none;
      }

      .login-btn {
        display: block;
        width: 100%;
        padding: 12px;
        background-color: #3498db;
        color: white;
        text-decoration: none;
        border: none;
        border-radius: 25px;
        font-size: 1.1em;
        cursor: pointer;
        transition: all 0.3s ease;
        box-shadow: 0 4px 6px rgba(0,0,0,0.1);
      }

      .login-btn:hover {
        background-color: #2980b9;
        transform: translateY(-2px);
        box-shadow: 0 6px 12px rgba(0,0,0,0.15);
      }

      .extra-links {
        text-align: center;
        margin-top: 20px;
      }

      .extra-links a {
        color: #3498db;
        text-decoration: none;
        font-size: 0.9em;
      }

      .extra-links a:hover {
        text-decoration: underline;
      }
    </style>
</head>
<body>
<div class="login-container">
    <div class="header-decoration"></div>
    <h2>로그인</h2>
    <form:form modelAttribute="signinForm" action="/member/member-login" method="post">
        <div class="form-group">
            <label for="email">아이디</label>
            <form:input path="email" id="email" placeholder="이메일을 입력하세요" cssClass="form-control"/>
            <form:errors path="email" cssClass="helper-text"/>
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <form:input path="password" id="password" type="password" placeholder="비밀번호를 입력하세요" cssClass="form-control"/>
            <form:errors path="password" cssClass="helper-text"/>
        </div>
        <div class="form-group">
            <label>
                <input type="checkbox" name="remember-me" />
                <span>remember-me?</span>
            </label>
        </div>
        <button type="submit" class="login-btn">로그인</button>
    </form:form>
    <div class="extra-links">
        <a href="/member/signup">회원가입</a>
    </div>
</div>
</body>
</html>