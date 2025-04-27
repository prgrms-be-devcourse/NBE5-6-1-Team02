<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/assets/css/member-login.css">
<head>
    <title>쇼핑몰 - 로그인</title>

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