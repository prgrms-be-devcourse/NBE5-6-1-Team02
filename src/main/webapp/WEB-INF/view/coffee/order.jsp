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
    </style>
    <title>상품 주문 페이지</title>
</head>
<body class="container-fluid">
<div class="row justify-content-center m-4">
    <h1 class="text-center">상품 목록 & 결제</h1>
</div>
<div class="card">
    <div class="row">
        <div class="col-md-8 mt-4 d-flex flex-column align-items-start p-3 pt-0">
            <h5><b>상품 목록</b></h5>
            <ul class="list-group w-100">
                <c:forEach items="${products}" var="product">
                    <li class="list-group-item d-flex mt-3">
                        <div class="col-2"><img class="img-fluid" src="${product.imageUrl}" alt=""></div>
                        <div class="col">
                            <div>${product.name}</div>
                        </div>
                        <div class="col text-center">${product.price}원</div>
                        <div class="col text-end">
                            <a class="btn btn-small btn-outline-dark" href="${pageContext.request.contextPath}/cart/add?id=${product.id}">추가</a>
                        </div>
                    </li>
                </c:forEach>
            </ul>
        </div>

        <div class="col-md-4 summary p-4">
            <h5><b>결제 정보</b></h5>
            <hr>
            <c:forEach items="${cartItems}" var="item">
                <div class="row">
                    <h6>${item.name} <span class="badge bg-dark">${item.quantity}개</span></h6>
                </div>
            </c:forEach>

            <form action="${pageContext.request.contextPath}/order" method="post">
                <div class="mb-3">
                    <label class="form-label">이메일</label>
                    <input type="email" name="email" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">주소</label>
                    <input type="text" name="address" class="form-control">
                </div>
                <div class="mb-3">
                    <label class="form-label">우편번호</label>
                    <input type="text" name="postcode" class="form-control">
                </div>
                <div>당일 오후 2시 이후의 주문은 다음날 배송을 시작합니다.</div>

                <div class="row pt-2 pb-2 border-top">
                    <h5 class="col">총금액</h5>
                    <h5 class="col text-end">${totalPrice}원</h5>
                </div>
                <button type="submit" class="btn btn-dark col-12">결제하기</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>