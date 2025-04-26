<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/view/include/page.jsp" %>
<link rel="stylesheet" href="/assets/css/mypage.css">
<html>
<head>
    <title>Grepp</title>
    <%@ include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>

<%@ include file="/WEB-INF/view/include/header.jsp" %>
<%@ include file="/WEB-INF/view/include/sidenav.jsp" %>

<main>
    <div class="profile-card z-depth-2">
        <h4>회원 정보</h4>
        <div>
            <span class="profile-label">이메일</span>
            <div class="profile-value"><c:out value="${member.email}"/></div>
        </div>
        <div>
            <span class="profile-label">전화번호</span>
            <div class="profile-value"><c:out value="${member.tel}"/></div>
        </div>
        <div>
            <span class="profile-label">주소</span>
            <div class="profile-value"><c:out value="${member.address}"/></div>
        </div>
        <div>
            <span class="profile-label">우편번호</span>
            <div class="profile-value"><c:out value="${member.zipcode}"/></div>
        </div>
    </div>
</main>

<%@ include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>
