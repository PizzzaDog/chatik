<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
<b>Hello <c:out value="${username}"/> </b>
<input type="hidden" name="username" value="${username}">
<form method="post" name="username" action="${pageContext.request.contextPath}/check">
    <label>
        <input type="text"/>
    </label>
    <button>go</button>
</form>
</body>