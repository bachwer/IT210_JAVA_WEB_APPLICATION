<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>
    Xin chào, ${sessionScope.loggedUser}!
    Vai trò: ${sessionScope.role}
</h2>

<a href="/logout">Đăng xuất</a>

<table border="1" cellpadding="10">
    <tr>
        <th>Mã</th>
        <th>Sản phẩm</th>
        <th>Tổng tiền</th>
        <th>Ngày</th>
    </tr>

    <c:forEach items="${orderList}" var="o" >
        <tr>
            <td>${o.id}</td>
            <td>${o.productName}</td>
            <td>
                <fmt:formatNumber value="${o.total}" type="currency" currencySymbol="₫"/>
            </td>
            <td>
                <fmt:formatDate value="${o.orderDate}" pattern="dd/MM/yyyy"/>
            </td>
        </tr>
    </c:forEach>
</table>

<h3>
    Tổng lượt xem: ${applicationScope.totalViewCount}
</h3>

</body>