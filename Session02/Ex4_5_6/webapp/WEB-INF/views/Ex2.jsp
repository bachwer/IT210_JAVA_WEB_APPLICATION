<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 06/04/2026
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
  table {
    border-collapse: collapse;
  }
  th, td {
    padding: 10px 20px; /* trên/dưới 10px, trái/phải 20px */
    border: 1px solid black;
  }
</style>
<body>
<h1>${reportTitle}</h1>

<table>
  <tr>
    <th>STT</th>
    <th>Họ & Tên</th>
    <th>Address</th>
    <th>Age</th>
    <th>Score</th>
    <th>Rank</th>
  </tr>

  <c:forEach items="${studentList}" var="sv" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td><c:out value="${sv.name}" /></td>
      <td><c:out value="${sv.address}" /></td>
      <td><c:out value="${sv.age}" /></td>
      <td><c:out value="${sv.score}" /></td>

      <td>
        <c:choose>
          <c:when test="${sv.score >= 3.8}">Xuất sắc</c:when>
          <c:when test="${sv.score >= 3.2}">Giỏi</c:when>
          <c:when test="${sv.score >= 2.5}">Khá</c:when>
          <c:when test="${sv.score >= 2.0}">Trung bình</c:when>
          <c:when test="${sv.score >= 0}">Yếu</c:when>
          <c:otherwise>Chưa có điểm</c:otherwise>
        </c:choose>
      </td>
    </tr>
  </c:forEach>
</table>


</body>
</html>
