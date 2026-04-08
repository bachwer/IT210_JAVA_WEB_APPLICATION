<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h2>Danh sách bàn</h2>

<form action="list" method="get">
    Lọc sức chứa: <input name="cap" type="number">
    <button type="submit">Tìm</button>
</form>

<p style="color:red">${msg}</p>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Capacity</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:forEach var="t" items="${tables}">
        <tr>
            <td>${t.id}</td>
            <td>${t.capacity}</td>
            <td>${t.status}</td>

            <td>
                <a href="${t.id}">Chi tiết</a>

                <form action="update-status" method="post" style="display:inline">
                    <input type="hidden" name="id" value="${t.id}">
                    <input type="hidden" name="status" value="Đang dùng">
                    <button type="submit">Nhận bàn</button>
                </form>

                <form action="delete/${t.id}" method="post" style="display:inline">
                    <button type="submit">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>