<%@ page language="java" %>
<link rel="stylesheet" href="/assets/css/header.css">
<header class="header">
    <nav class="navbar">
        <div class="nav-wrapper">
            <a href="/" class="brand-logo">Grepp</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down">
                <!-- 비로그인 사용자 -->
                <sec:authorize access="isAnonymous()">
                    <li><a href="/member/signin" class="nav-link">Sign In</a></li>
                    <li><a href="/member/signup" class="nav-link">Sign Up</a></li>
                </sec:authorize>

                <!-- 로그인한 사용자 (일반 사용자) -->
                <sec:authorize access="hasRole('USER')">
                    <li><a href="/member/fixinfo" class="nav-link">Fix Info</a></li>
                    <li><a href="/coffee/member-order" class="nav-link">Order</a></li>
                </sec:authorize>

                <!-- 관리자 -->
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="/admin/product-list" class="nav-link">List</a></li>
                    <li><a href="/admin/coffee/product-regist" class="nav-link">Regist</a></li>
                </sec:authorize>

                <!-- 로그인한 사용자 (로그아웃 포함) -->
                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form:form action="/logout" method="POST" style="display:inline;">
                            <button type="submit" class="nav-link logout-btn">Logout</button>
                        </form:form>
                    </li>
                </sec:authorize>

                <li>
                    <a href="mobile.html">
                        <i class="material-icons sidenav-trigger" data-target="slide-out">more_vert</i>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
</header>
