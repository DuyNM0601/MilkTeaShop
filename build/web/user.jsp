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

        <h0 style="font-size: 20px;">User ID: ${sessionScope.LOGIN_USER.userID}</h0></br>
        <h0 style="font-size: 20px">Full name:${sessionScope.LOGIN_USER.fullname} </h0></br>
        <h0 style="font-size: 20px">Role ID:${sessionScope.LOGIN_USER.roleID}</h0></br>
        <h0 style="font-size: 20px">Password: ${sessionScope.LOGIN_USER.password}</h0></br>
        <footer>
            <%@include file="footer.jsp" %>
        </footer>
    </body>
    <a href="shopping.jsp">Shopping</a>
    
</html>
