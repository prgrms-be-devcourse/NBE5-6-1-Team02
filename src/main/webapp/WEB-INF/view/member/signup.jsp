<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/assets/css/signup.css">
<head>
  <title>쇼핑몰 - 회원가입</title>
</head>
<body>
<div class="signup-container">
  <div class="header-decoration"></div>
  <h2>회원가입</h2>

  <form:form modelAttribute="signupForm" method="post" action="/member/signup">
    <div class="form-group">
      <label for="email">이메일</label>
      <form:input path="email" id="email" placeholder="이메일을 입력하세요" />
      <form:errors path="email" cssClass="helper-text" />
    </div>

    <div class="form-group">
      <label for="password">비밀번호</label>
      <form:password path="password" id="password" placeholder="비밀번호를 입력하세요" />
      <form:errors path="password" cssClass="helper-text" />
    </div>

    <div class="form-group">
      <label for="tel">전화번호</label>
      <form:input path="tel" id="tel" placeholder="전화번호를 입력하세요" />
      <form:errors path="tel" cssClass="helper-text" />
    </div>

    <div class="form-group">
      <label for="address">주소</label>
      <form:input path="address" id="address" placeholder="주소를 입력하세요" />
      <form:errors path="address" cssClass="helper-text" />
    </div>

    <div class="form-group">
      <label for="zipCode">우편번호</label>
      <form:input path="zipCode" id="zipCode" placeholder="우편번호를 입력하세요" />
      <form:errors path="zipCode" cssClass="helper-text" />
    </div>

    <button type="submit" class="signup-btn">회원가입</button>
  </form:form>

  <div class="extra-links">
    <a href="/member/member-login">이미 계정이 있으신가요? 로그인</a>
  </div>
</div>
</body>
</html>