<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Developer</title>
</head>
<body>

<h2>Enter developer information</h2>
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