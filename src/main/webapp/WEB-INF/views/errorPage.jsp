<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
  <title>Error Page</title>
</head>
<body>

<h2>Error ${errorMessage} !</h2>
<form action="hello" method="get">
            <label>
                <button type="submit">Exit</button>
            </label>
 </form>
</body>
</html>