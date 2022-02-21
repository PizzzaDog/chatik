<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<title>Kek</title>
<table>
    <jsp:include page="message_table.jsp"/>
    <tr>
        <th></th>
        <th>sender</th>
        <th>text</th>
    </tr>
    <c:forEach var="message" items="${messages}">
        <tr>
            <td ><c:out value="${message.time}"/></td>
            <td><b><c:out value="${message.sender}"/></b></td>
            <td><c:out value="${message.text}"/></td>
        </tr>
    </c:forEach>
</table>
<c:if test="${empty username}">
    <% response.reset(); %>
    <form action="${pageContext.request.contextPath}/messages" method="post" >
       <label>
           <input disabled type="text" name="username">
           <button type="submit">Login</button>
       </label>
   </form>

</c:if>
<c:if test="${not empty username}">
    <form action="${pageContext.request.contextPath}/messages" method="post">
        <label>
            <input disabled type="hidden" name="username" value="${username}">
            <input disabled type="text" name="text"/>
            <button type="submit">Send</button>
        </label>
    </form>
</c:if>