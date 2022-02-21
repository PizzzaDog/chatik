<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<b>
    <form action="${pageContext.request.contextPath}/checkCreds" method="post" >
        Введите пароль
        <label>
            <input disabled type="text" name="username">
            <input type="hidden" name="username" value="${username}">
            <input type="hidden" name="redirect" value="${redirect}">
            <input type="text" name="password"/>
            <button type="submit">Login</button>
        </label>
    </form>
</b>