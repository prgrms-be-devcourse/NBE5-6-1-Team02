<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
    <style>
      body { background: #ddd; }
      .card {
        margin: auto;
        max-width: 950px;
        width: 90%;
        box-shadow: 0 6px 20px 0 rgba(0, 0, 0, 0.19);
        border-radius: 1rem;
        border: transparent;
      }
      .summary {
        background-color: #ddd;
        border-top-right-radius: 1rem;
        border-bottom-right-radius: 1rem;
        padding: 4vh;
        color: rgb(65, 65, 65);
      }
      @media (max-width: 767px) {
        .summary {
          border-top-right-radius: unset;
          border-bottom-left-radius: 1rem;
        }
      }
      .member-badge {
        display: inline-block;
        background-color: #28a745;
        color: white;
        padding: 0.35rem 0.65rem;
        border-radius: 0.25rem;
        margin-left: 0.5rem;
      }
      .user-info {
        background-color: #f8f9fa;
        padding: 10px;
        border-radius: 5px;
        margin-bottom: 15px;
      }
    </style>
    <title>주문 페이지</title>
</head>
<body class="container-fluid">
<div class="row justify-content-center m-4">
    <h1 class="text-center">회원 주문 </h1>
</div>
<div class="card">
    <div class="row">
        <div class="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
            <h5><b>상품 목록</b></h5>
            <ul class="list-group w-100">
                <c:forEach items="${products}" var="product">
                    <div class="col-2">
                        <img class="img-fluid" src="${pageContext.request.contextPath}/upload/${product.img}">
                    </div>
                        <div class="col">
                            <div>${product.name}</div>
                        </div>
                        <div class="col text-center">${product.price}원</div>
                        <div class="col text-end">
                            <a href="#" class="btn btn-sm btn-outline-dark"
                               onclick="addToCart('${product.cpIdx}', '${product.name}', ${product.price})">추가</a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="col-md-4 summary p-4">
            <div class="user-info">
                <h6 class="mb-2">로그인 정보</h6>
                <p class="mb-0"><strong>이메일:</strong> ${userEmail}</p>
            </div>

            <h5><b>결제 정보</b></h5>
            <hr>
            <div id="cart-area"></div>

            <form action="${pageContext.request.contextPath}/order" method="post">
                <!-- 히든 필드로 이메일 전송 -->
                <input type="hidden" id="email" name="email" value="${userEmail}">

                <div class="mb-3">
                    <label class="form-label">주소</label>
                    <input type="text" name="address" id="address" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">우편번호</label>
                    <input type="text" name="postcode" id="postcode" class="form-control" required>
                </div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>

                <button type="button" class="btn btn-dark col-12 mt-3" onclick="submitOrder()">결제하기</button>
            </form>
        </div>
    </div>
</div>
</body>
<script>
  var csrfToken = '${_csrf.token}';
</script>
<script src="${pageContext.request.contextPath}/assets/js/cart.js"></script>
</html>