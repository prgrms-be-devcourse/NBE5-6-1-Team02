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
    <form:form action="${context}/book/regist" method="post" enctype="multipart/form-data" modelAttribute="ProductForm">
        <div class="file-field input-field">
            <div class="btn">
                <span>File</span>
                <input type="file" name="pd_Img">
            </div>
            <div class="file-path-wrapper">
                <input class="file-path validate" type="text">
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <form:textarea path="name" name="name" id="icon_prefix3" class="materialize-textarea"/>
                <form:errors path="name" />
                <label for="icon_prefix3">상품명</label>
            </div>
        </div>
        <div class="row">
            <div class="input-field col s6">
                <i class="material-icons prefix">mode_edit</i>
                <form:textarea path="price" name="price" id="icon_prefix4" class="materialize-textarea"/>
                <form:errors path="price" />
                <label for="icon_prefix4">가격</label>
            </div>
        </div>
        <button class="btn waves-effect waves-light offset-s1" type="submit" name="action">
            Submit
            <i class="material-icons right">send</i>
        </button>
    </form:form>
</main>
<%@include file="/WEB-INF/view/include/footer.jsp" %>

</body>
</html>