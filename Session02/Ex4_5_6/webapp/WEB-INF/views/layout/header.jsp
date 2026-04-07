<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 07/04/2026
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div style="background-color:#2c3e50; color:white; padding:15px;">

    <h2>Mini HR Portal</h2>

    <!-- Navigation Menu -->
    <div style="margin-top:10px;">
        <a href="<c:url value='/employees'/>" style="color:white; margin-right:15px;">Danh sách nhân viên</a>

        <!-- Menu chỉ dành cho Manager -->
        <c:if test="${sessionScope.role == 'hr_manager'}">
            <a href="#" style="color:yellow; margin-right:15px;">Quản lý nâng cao</a>
        </c:if>

        <!-- Logout -->
        <a href="<c:url value='/logout'/>" style="color:red;">Đăng xuất</a>
    </div>

    <!-- Thông tin user -->
    <div style="margin-top:10px;">
        Xin chào:
        <strong>
            <c:out value="${sessionScope.loggedUser}" />
        </strong>
        (<c:out value="${sessionScope.role}" />)
    </div>
</div>


</body>
</html>
