<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet" href="/assets/css/fixinfo.css">
  <title>쇼핑몰 - 회원 탈퇴</title>
</head>
<body>
<div class="signup-container">
  <div class="header-decoration"></div>
  <h2>회원 탈퇴</h2>

  <!-- 탈퇴 폼 시작 -->
  <form:form modelAttribute="deleteForm" method="post" action="/member/delete">

    <div class="form-group">
      <label for="password">비밀번호</label>
      <form:password path="password" id="password" placeholder="비밀번호를 입력하세요" />
      <form:errors path="password" cssClass="helper-text" />
    </div>

    <button type="submit" class="signup-btn">회원 탈퇴</button>
  </form:form>

  <!-- 에러 메시지 표시 -->
  <c:if test="${not empty errorMessage}">
    <div class="error-message" style="color:red; margin-top:15px;">${errorMessage}</div>
    <c:remove var="errorMessage" scope="session"/>
  </c:if>

</div>
</body>
</html>