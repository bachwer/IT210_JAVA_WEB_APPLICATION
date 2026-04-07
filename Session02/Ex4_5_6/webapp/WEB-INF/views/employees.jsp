<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ include file="/WEB-INF/views/layout/header.jsp" %>

<h2>Danh sách nhân viên</h2>

<table border="1" cellpadding="8" cellspacing="0" width="100%">
  <thead style="background-color:#f2f2f2;">
  <tr>
    <th>STT</th>
    <th>Mã NV</th>
    <th>Họ tên</th>
    <th>Phòng ban</th>
    <th>Lương</th>
    <th>Ngày vào làm</th>
    <th>Trạng thái</th>
    <th>Chi tiết</th>
  </tr>
  </thead>

  <tbody>
  <c:forEach var="emp" items="${employees}" varStatus="st">
    <tr>
      <!-- STT -->
      <td><c:out value="${st.count}" /></td>

      <!-- Code -->
      <td><c:out value="${emp.code}" /></td>

      <!-- Name -->
      <td><c:out value="${emp.name}" /></td>

      <!-- Department -->
      <td><c:out value="${emp.department}" /></td>

      <!-- Salary -->
      <td>
        <fmt:formatNumber value="${emp.salary}" type="number" groupingUsed="true"/> VNĐ
      </td>

      <!-- Date -->
      <td>
        <c:out value="${emp.joinDate}" />
      </td>

      <!-- Status -->
      <td>
        <c:choose>
          <c:when test="${emp.status == 'Đang làm'}">
            <span style="color:white; background:green; padding:3px 6px;">Đang làm</span>
          </c:when>
          <c:when test="${emp.status == 'Nghỉ phép'}">
            <span style="color:white; background:orange; padding:3px 6px;">Nghỉ phép</span>
          </c:when>
          <c:when test="${emp.status == 'Thử việc'}">
            <span style="color:white; background:blue; padding:3px 6px;">Thử việc</span>
          </c:when>
        </c:choose>
      </td>

      <!-- Detail -->
      <td>
        <a href="<c:url value='/employees/${emp.code}'/>">Xem chi tiết</a>
      </td>
    </tr>
  </c:forEach>
  </tbody>

  <!-- Tổng lương -->
  <tfoot>
  <tr>
    <td colspan="4"><strong>Tổng lương phòng Kỹ thuật</strong></td>
    <td colspan="4">
      <strong>
        <fmt:formatNumber value="${totalTechSalary}" type="number" groupingUsed="true"/> VNĐ
      </strong>
    </td>
  </tr>
  </tfoot>
</table>

<%@ include file="/WEB-INF/views/layout/footer.jsp" %>