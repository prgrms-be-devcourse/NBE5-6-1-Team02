<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <link rel ="stylesheet" href="/assets/css/fixinfo.css">
  <title>쇼핑몰 - 회원가입</title>
</head>
<body>
<div class="signup-container">
  <div class="header-decoration"></div>
  <h2>회원정보 수정</h2>

  <form:form modelAttribute="updateForm" method="post" action="/member/fixinfo">

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

    <button type="submit" class="signup-btn">정보 수정</button>
  </form:form>

</div>
</body>
</html>