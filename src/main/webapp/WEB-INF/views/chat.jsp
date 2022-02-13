<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h2>Hello ${sender} !</h2>

<table>
    <tr>
        <th>sender</th>
        <th>text</th>
    </tr>
      <c:forEach items="${allMessage}" var="chatList">
            <tr>
                <td>${chatList.time}</td>
                <td>${chatList.getSender()}</td>
                <td>${chatList.text}</td>
            </tr>
        </c:forEach>
</table>

<h4>Add new message</h4>
 <form action="addMessage" method="post">
        <label>
            <input type="hidden" name="sender" value="${sender}">
            <input type="text" name="text"/>
            <button type="submit">Send</button>
        </label>
    </form>
     <form action="hello" method="get">
            <label>
                <button type="submit">Exit</button>
            </label>
        </form>
</body>
</html>
