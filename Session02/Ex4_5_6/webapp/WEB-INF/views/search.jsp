<%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 06/04/2026
  Time: 18:30
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Kết quả tìm kiếm</title>
</head>
<body>

<!-- ===== HEADER ===== -->
<h2>
    Kết quả tìm kiếm cho:
    <c:out value="${keyword}" escapeXml="true"/>
</h2>

<p>
    Tìm thấy ${fn:length(events)} sự kiện
</p>

<!-- Nếu không có kết quả -->
<c:if test="${empty events}">
    <p style="color:red">Không tìm thấy sự kiện nào phù hợp.</p>
</c:if>

<!-- ===== TABLE ===== -->
<c:if test="${not empty events}">
    <table border="1" cellpadding="10">
        <tr>
            <th>STT</th>
            <th>Tên sự kiện</th>
            <th>Ngày</th>
            <th>Giá vé</th>
            <th>Vé còn lại</th>
            <th>Thao tác</th>
        </tr>

        <c:forEach items="${events}" var="event" varStatus="stt">
            <tr>
                <!-- STT -->
                <td>${stt.count}</td>

                <!-- Tên (CHỐNG XSS) -->
                <td>
                    <c:out value="${event.name}" escapeXml="true"/>
                </td>

                <!-- Ngày -->
                <td>${event.date}</td>

                <!-- Giá -->
                <td>
                    <c:choose>
                        <c:when test="${event.price == 0}">
                            <span style="color:green">MIỄN PHÍ</span>
                        </c:when>
                        <c:otherwise>
                            <fmt:formatNumber value="${event.price}" type="number"/>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- Vé còn lại -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:red">HẾT VÉ</span>
                        </c:when>
                        <c:when test="${event.remainingTickets < 10}">
                            <span style="color:orange">
                                Sắp hết (còn ${event.remainingTickets} vé)
                            </span>
                        </c:when>
                        <c:otherwise>
                            <span style="color:green">
                                    ${event.remainingTickets}
                            </span>
                        </c:otherwise>
                    </c:choose>
                </td>

                <!-- Action -->
                <td>
                    <c:choose>
                        <c:when test="${event.remainingTickets == 0}">
                            <span style="color:gray">Không khả dụng</span>
                        </c:when>
                        <c:otherwise>
                            <a href="<c:url value='/events/${event.id}/book'/>">
                                Đặt vé
                            </a>
                        </c:otherwise>
                    </c:choose>
                </td>

            </tr>
        </c:forEach>
    </table>
</c:if>

<!-- ===== FOOTER ===== -->

<!-- Event đầu tiên -->
<c:if test="${not empty events}">
    <p>
        Sự kiện đầu tiên:
            ${fn:toUpperCase(events[0].name)}
    </p>
</c:if>

<!-- Độ dài keyword -->
<p>
    Độ dài từ khóa: ${fn:length(keyword)} ký tự
</p>

</body>
</html>