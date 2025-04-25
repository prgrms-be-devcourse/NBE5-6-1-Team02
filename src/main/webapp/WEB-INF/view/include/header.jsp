<%@ page language="java" %>
<header class="header">
    <nav class="navbar white">
        <div class="nav-wrapper ">
            <a href="/" class="brand-logo grey-text">Grepp</a>
            <ul id="nav-mobile" class="right hide-on-med-and-down grey-text">
                <sec:authorize access="isAnonymous()">
                    <li><a href="/member/signin" class="grey-text">sign in</a></li>
                    <li><a href="/member/signup" class="grey-text">sign up</a></li>
                    <li>
                        <a href="mobile.html">
                            <i class="material-icons grey-text sidenav-trigger"
                               data-target="slide-out">more_vert</i>
                        </a>
                    </li>
                </sec:authorize>
                <sec:authorize access="hasRole('USER')">
                    <li><a href="/member/fixinfo" class="grey-text">fixinfo</a></li>

                    <li><a href="/coffee/member-order" class="grey-text">order</a></li>

                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <li><a href="/admin/product-list" class="grey-text">List</a></li>
                    <li><a href="/admin/coffee/product-regist" class="grey-text">Regist</a></li>
                </sec:authorize>

                <sec:authorize access="isAuthenticated()">
                    <li>
                        <form:form action="/logout" method="POST" style="display:inline;">
                            <button type="submit" class="grey-text" style="background:none; border:none; color: inherit; font-size: inherit; cursor: pointer;">logout</button>
                        </form:form>
                    </li>
                </sec:authorize>
                <li>
                    <a href="mobile.html">
                        <i class="material-icons grey-text sidenav-trigger"
                           data-target="slide-out">more_vert</i>
                    </a>
                </li>

            </ul>
        </div>
    </nav>
</header>

