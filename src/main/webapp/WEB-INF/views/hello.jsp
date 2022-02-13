<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Hello</title>
</head>
<body>

<h2>Enter sender information</h2>
<form method="post" action="chat">
  <table>
    <tr>
      <td><label path="sender">Sender</label></td>
      <td><input type="text" name="sender" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Submit"/>
      </td>
    </tr>
  </table>
</form>
</body>
</html>