<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비회원 주문</title>

    <!-- 공통 CSS 적용 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/cart.css">

    <style>
      /* 추가 스타일 */
      .order-wrapper {
        display: flex;
        flex-wrap: wrap;
        gap: 20px;
      }
      .product-section {
        flex: 1 1 55%;
        min-width: 300px;
      }
      .order-section {
        flex: 1 1 40%;
        min-width: 320px;
      }
      @media (max-width: 768px) {
        .order-wrapper {
          flex-direction: column;
        }
      }

      .product-item {
        display: flex;
        align-items: center;
        padding: 15px 0;
        border-bottom: 1px solid #eee;
      }
      .product-thumbnail {
        width: 80px;
        height: 80px;
        object-fit: cover;
        border-radius: 8px;
        margin-right: 15px;
      }
      .product-info {
        flex-grow: 1;
        overflow: hidden;
      }
      .product-name {
        font-weight: bold;
        font-size: 1.1em;
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
      }
      .product-price {
        font-size: 0.9em;
        color: #555;
      }
      .product-action {
        margin-left: 10px;
      }
      .user-info {
        background-color: #f8f9fa;
        padding: 15px;
        border-radius: 8px;
        margin-bottom: 20px;
      }
      .guest-badge {
        display: inline-block;
        background-color: #dc3545;
        color: white;
        padding: 0.35rem 0.65rem;
        border-radius: 0.25rem;
        margin-left: 0.5rem;
        font-size: 0.8rem;
      }
    </style>
</head>

<body>
<div class="header-decoration"></div>

<h1>주문하기</h1>

<div class="card" style="padding: 20px;">
    <div class="order-wrapper">
        <!-- 왼쪽: 상품 목록 -->
        <div class="product-section">
            <h2>상품 목록</h2>
            <c:forEach items="${products}" var="product">
                <div class="product-item">
                    <img src="${pageContext.request.contextPath}/upload/${product.img}" alt="상품 이미지" class="product-thumbnail">

                    <div class="product-info">
                        <div class="product-name">${product.name}</div>
                        <div class="product-price">${product.price}원</div>
                    </div>

                    <div class="product-action">
                        <a href="#" class="btn-primary" style="width:auto; padding:8px 20px; font-size:0.9em;"
                           onclick="addToCart('${product.cpIdx}', '${product.name}', ${product.price})">
                            추가
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>

        <!-- 오른쪽: 결제 영역 -->
        <div class="order-section">
            <div class="user-info">
                <c:choose>
                    <c:when test="${not empty guestEmail}">
                        <p><span class="guest-badge">비회원</span> ${guestEmail}</p>
                    </c:when>
                    <c:otherwise>
                        <p>비회원 이메일 입력 필요</p>
                    </c:otherwise>
                </c:choose>
            </div>

            <h2>결제 정보</h2>
            <div id="cart-area" style="margin-bottom: 20px;"></div>

            <form action="${pageContext.request.contextPath}/order" method="post">
                <c:choose>
                    <c:when test="${not empty guestEmail}">
                        <input type="hidden" id="email" name="email" value="${guestEmail}">
                    </c:when>
                    <c:otherwise>
                        <div>
                            <label>이메일</label>
                            <input type="email" id="email" name="email" class="form-control" required>
                        </div>
                    </c:otherwise>
                </c:choose>

                <div>
                    <label>주소</label>
                    <input type="text" id="address" name="address" class="form-control" required>
                </div>

                <div>
                    <label>우편번호</label>
                    <input type="text" id="postcode" name="postcode" class="form-control" required>
                </div>

                <div class="order-info" style="margin-top: 10px;">
                    당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.
                </div>

                <button type="button" class="btn-primary" onclick="submitOrder()" style="margin-top:20px;">결제하기</button>
            </form>
        </div>
    </div>
</div>

<script>
  var csrfToken = '${_csrf.token}';
</script>
<script src="${pageContext.request.contextPath}/assets/js/cart.js"></script>
</body>
</html>
