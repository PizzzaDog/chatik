<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
<h2>Hello ${sender} !</h2>

<table>
    <tr>
        <th>id</th>
        <th>sender</th>
        <th>text</th>
        <th>time</th>
    </tr>
      <c:forEach items="${allMessage}" var="chatList">
            <tr>
                <td>${chatList.id}</td>
                <td>${chatList.getSender()}</td>
                <td>${chatList.text}</td>
                <td>${chatList.time}</td>
            </tr>
        </c:forEach>
</table>

<h4>Add new message</h4>
<form:form method="post" action="chat">
  <table>
    <tr>
      <td><form:label path="sender">Sender</form:label></td>
      <td><form:input path="sender" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form:form>
</body>
</html>
