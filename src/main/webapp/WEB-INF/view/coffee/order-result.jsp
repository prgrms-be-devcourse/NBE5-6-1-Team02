<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>주문 완료</title>

    <!-- 공통 CSS 적용 -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/cart.css">

    <style>
      .order-wrapper {
        display: flex;
        flex-direction: column;
        gap: 20px;
      }

      .order-section {
        width: 100%;
      }

      .order-details {
        background-color: #f8f9fa;
        padding: 20px;
        border-radius: 8px;
        margin-bottom: 20px;
      }

      .order-info {
        display: flex;
        justify-content: space-between;
        padding: 10px 0;
        border-bottom: 1px solid #eee;
      }

      .order-info:last-child {
        border-bottom: none;
      }

      .order-label {
        font-weight: bold;
        color: #555;
      }

      .order-items {
        margin-top: 30px;
      }

      .item-row {
        display: flex;
        justify-content: space-between;
        padding: 12px 0;
        border-bottom: 1px solid #eee;
      }

      .item-name {
        font-weight: bold;
      }

      .item-quantity {
        color: #555;
      }

      .user-info {
        background-color: #f8f9fa;
        padding: 15px;
        border-radius: 8px;
        margin-bottom: 20px;
      }

      .success-message {
        text-align: center;
        color: #28a745;
        font-size: 1.2em;
        margin: 20px 0;
      }

      .guest-badge {
        display: inline-block;
        background-color: #dc3545;
        color: white;
        padding: 0.35rem 0.65rem;
        border-radius: 0.25rem;
        margin-right: 0.5rem;
        font-size: 0.8rem;
      }

      .member-badge {
        display: inline-block;
        background-color: #28a745;
        color: white;
        padding: 0.35rem 0.65rem;
        border-radius: 0.25rem;
        margin-right: 0.5rem;
        font-size: 0.8rem;
      }

      .home-btn {
        display: inline-block;
        background-color: #3498db;
        color: white;
        text-decoration: none;
        padding: 10px 20px;
        border-radius: 5px;
        margin-top: 20px;
      }

      .home-btn:hover {
        background-color: #2980b9;
      }
    </style>
</head>

<body>
<div class="header-decoration"></div>

<h1>주문 완료</h1>

<div class="card" style="padding: 20px;">
    <div class="success-message">
        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
            <path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"></path>
            <polyline points="22 4 12 14.01 9 11.01"></polyline>
        </svg>
        주문이 성공적으로 완료되었습니다!
    </div>
    <div style="margin-top: 10px; text-align: center;">
        당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.
    </div>

    <div class="order-wrapper">
        <div class="order-section">
            <h2>주문 정보</h2>

            <div class="order-details">
                <div class="order-info">
                    <span class="order-label">주문자:</span>
                    <span>
                        <c:choose>
                            <c:when test="${not empty sessionScope.guestEmail}">
                                <span class="guest-badge">비회원</span>
                            </c:when>
                            <c:otherwise>
                                <span class="member-badge">회원</span>
                            </c:otherwise>
                        </c:choose>
                        ${orderEmail}
                    </span>
                </div>

                <div class="order-info">
                    <span class="order-label">주문 시간:</span>
                    <span>
                        <fmt:formatDate value="${orderTime}" pattern="yyyy-MM-dd HH:mm:ss" />
                    </span>
                </div>
                <div class="order-info">
                    <span class="order-label">배송 예정일:</span>
                    <span>${deliveryMessage}</span>
                </div>

            </div>

            <h2>주문 상품</h2>

            <div class="order-items">
                <c:set var="totalPrice" value="0" />
                <c:forEach items="${orderItems}" var="item">
                    <div class="item-row">
                        <div class="item-name">${item.name}</div>
                        <div class="item-quantity">
                                ${item.quantity}개 × ${item.price}원 = ${item.quantity * item.price}원
                        </div>
                    </div>
                    <c:set var="totalPrice" value="${totalPrice + (item.quantity * item.price)}" />
                </c:forEach>

                <div class="item-row" style="margin-top:20px; border-top:2px solid #ddd; padding-top:15px;">
                    <div style="font-weight:bold;">총 결제금액</div>
                    <div style="font-weight:bold; color:#dc3545;">${totalPrice}원</div>
                </div>
            </div>

            <div style="text-align:center; margin-top:30px;">
                <a href="${pageContext.request.contextPath}/" class="home-btn">홈으로 돌아가기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>