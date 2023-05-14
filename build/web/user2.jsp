<%-- 
    Document   : user
    Created on : Apr 13, 2023, 3:42:57 PM
    Author     : duy
--%>

<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <h1>User information </h1>
    <c:if test="${sessionScope.LOGIN_USER == null || sessionScope.LOGIN_USER.roleID ne 'US'}">
        <c:redirect url="login.html"></c:redirect>
    </c:if>
    User ID: ${sessionScope.LOGIN_USER.userID} </br>
    Full name:${sessionScope.LOGIN_USER.fullname} </br>
    Role ID:${sessionScope.LOGIN_USER.roleID}</br>
    Password: ${sessionScope.LOGIN_USER.password}</br>
    <a href="shopping.jsp">Shopping</a>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>

</html>
