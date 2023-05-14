<%-- 
    Document   : user3
    Created on : Apr 25, 2023, 5:42:58 PM
    Author     : duy
--%>

<%@page import="java.util.List"%>
<%@page import="sample.dto.User"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>select top 2</h1>
        <%
            List<User> listUser = (List<User>) request.getAttribute("USER2");
            if (listUser != null) {
                if (listUser.size() > 0) {
        %>
        <table border='1'>
            <thead>
                <tr>               
                    <th>User ID</th>
                    <th>Full Name</th>
                    <th>Role ID</th>
                    <th>Password</th>
                    
                </tr>
            </thead>
            <tbody>
                <%
                   
                    for (User userList : listUser) {

                %>
                 <tr>
                    
                    <td><%= userList.getUserID()%></td>
                    <td><%= userList.getFullname()%></td>
                    <td><%= userList.getRoleID()%></td>
                    <td><%= userList.getPassword()%></td>
                    
                 </tr>
                 <%
                 }
                 %>
                
                
                
        <%
                }
            }
        %>

    </body>
</html>
