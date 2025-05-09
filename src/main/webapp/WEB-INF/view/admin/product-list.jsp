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
<main class="container" style="margin-top: 80px;">
    <h4>등록된 상품 목록</h4>
    <ul class="collection book-list">
        <c:forEach items="${coffees}" var="coffee">
            <li class="collection-item avatar">
                <c:if test="${empty coffee.img}">
                    <img src="#" alt="thumbnail" class="circle">
                </c:if>

                <c:if test="${not empty coffee.img}">
                    <c:forEach items="${coffee.img}" var="image">
                        <img src="${pageContext.request.contextPath}/upload/${coffee.img}"
                             alt="thumbnail" class="circle" style="width: 90px; height: 70px;">
                    </c:forEach>
                </c:if>

                <div style="margin-left: 50px;"> <!-- 이미지와 겹치지 않게 왼쪽 여백 -->
                    <span class="title"><c:out value="${coffee.name}"/></span><br/>
                    <span><c:out value="가격 : ${coffee.price} 원"/></span><br/>
                    <span><c:out value="상품상태 : ${coffee.active == 1 ? '활성화' : '비활성화'}"/></span>
                </div>

                <!-- 오른쪽 비활성화 버튼 + 삭제 버튼 -->
                <span class="secondary-content"
                      style="display: flex; align-items: center; gap: 15px;">

                    <c:if test="${coffee.active == 1}">
                        <form:form action="${pageContext.request.contextPath}/admin/product/activated" method="post"
                                   style="margin: 0;">
                            <input type="hidden" name="coffeeName" value="${coffee.name}"/>
                            <button type="submit" class="btn-flat red-text"
                                    style="padding: 5px 10px; font-size: 14px; min-width: 120px;"
                                    onclick="return confirm('정말 비활성화하시겠습니까?');">
                                <i class="material-icons" style="font-size: 18px;">delete_forever</i> 비활성화
                            </button>
                        </form:form>
                    </c:if>


                    <c:if test="${coffee.active == 0}">
                        <form:form action="${pageContext.request.contextPath}/admin/product/re-activated" method="post"
                                   style="margin: 0;">
                            <input type="hidden" name="coffeeName" value="${coffee.name}"/>
                            <button type="submit" class="btn-flat red-text"
                                    style="padding: 5px 10px; font-size: 14px; min-width: 120px;"
                                    onclick="return confirm('정말 활성화하시겠습니까?');">
                                <i class="material-icons" style="font-size: 18px;">replay</i> 활성화
                            </button>
                        </form:form>
                    </c:if>

                </span>

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
<script src="${context}/assets/js/book-list.js" defer></script>
</body>
</html>
