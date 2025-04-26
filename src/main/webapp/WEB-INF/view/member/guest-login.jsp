<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="/assets/css/guest-login.css">
<head>
  <title>쇼핑몰 - 비회원 주문</title>
</head>
<body>
<div class="login-container">
  <div class="header-decoration"></div>
  <h2>비회원 주문</h2>
  <form action="${pageContext.request.contextPath}/member/guest-order" method="post">
    <div class="form-group">
      <label for="email">이메일</label>
      <input type="email" id="email" name="email" placeholder="이메일을 입력하세요" required>
    </div>
    <div>
    <button type="submit" class="login-btn">주문하러가기</button>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </div>
  </form>
  <div class="extra-links">
    <a href="/member/signup">회원가입</a> | <a href="/member/member-login">회원 로그인</a>
  </div>
</div>
</body>
</html>