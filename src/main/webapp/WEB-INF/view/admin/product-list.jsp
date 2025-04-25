<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/include/page.jsp" %>
<html>
<head>
    <title>Grepp</title>
    <%@include file="/WEB-INF/view/include/static.jsp" %>
</head>
<body>
<%@include file="/WEB-INF/view/include/header.jsp" %>
<%@include file="/WEB-INF/view/include/sidenav.jsp" %>
<main class="container">
    <h4>Product List</h4>
    <ul class="collection book-list">
        <c:forEach items="${coffees}" var="coffee">
            <li class="collection-item avatar">
                <c:if test="${empty coffee.img}">
                    <img src="#" alt="thumbnail" class="circle">
                </c:if>

                <c:if test="${not empty coffee.img}">
                    <c:forEach items="${coffee.img}" var="image">
                        <c:if test="${not empty coffee.img}">
                            <img src="${pageContext.request.contextPath}/upload/${coffee.img}" alt="thumbnail" class="circle">
                        </c:if>
                    </c:forEach>
                </c:if>
                <span class="title"><c:out value="상품명 : ${coffee.name}"/></span>
                <!-- 상품 가격 옆에 삭제 버튼 추가 -->
                <p>
                        <c:out value="가격 : ${coffee.price}"/>

                    <!-- 삭제 버튼 -->
                <form:form action="${pageContext.request.contextPath}/admin/product/delete" method="post" style="display:inline;">

                <input type="hidden" name="coffeeName" value="${coffee.name}" />
                    <button type="submit" class="btn-flat red-text" onclick="return confirm('정말 삭제하시겠습니까?');">
                        <i class="material-icons">delete</i>
                    </button>
                </form:form>
                </p>

                <a href="#" class="secondary-content"><i class="material-icons">grade</i></a>
            </li>
        </c:forEach>
    </ul>
</main>

<ul class="collection" id="bookListTemplate" style="display:none;">
    <li class="collection-item avatar">
        <img src="#" alt="thumbnail" class="circle thumbnail">
        <span class="title"></span>
        <p class="author"></p>
        <a href="#" class="secondary-content"><i class="material-icons">grade</i></a>
    </li>
</ul>

<span class="target" style="display:none;"></span>

<%@include file="/WEB-INF/view/include/footer.jsp" %>
<script src="${context}/assets/js/book-list.js" defer ></script>
</body>
</html>