<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<ul id="slide-out" class="sidenav">
    <%-- 사진 넣고 싶으면 사진 넣으세요! --%>
<%--    <li>--%>
<%--        <div class="user-view">--%>
<%--&lt;%&ndash;            <div class="background">&ndash;%&gt;--%>
<%--&lt;%&ndash;                <img src="${context}/assets/img/user2.png">&ndash;%&gt;--%>
<%--&lt;%&ndash;            </div>&ndash;%&gt;--%>
<%--        </div>--%>
<%--    </li>--%>
    <li><a href="/"><i class="material-icons">cloud</i>메인화면</a></li>
    <li><a href="/member/fixinfo">회원정보수정</a></li>
    <li>
        <div class="divider"></div>
    </li>
    <li><a class="subheader">상품</a></li>
    <li><a class="waves-effect" href="/coffee/member-order">상품주문하기</a></li>
</ul>
<script>
  document.addEventListener('DOMContentLoaded', function () {
    const elems = document.querySelectorAll('.sidenav');
    const instances = M.Sidenav.init(elems, {edge: 'right'});
  });
</script>
