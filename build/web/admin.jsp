<%-- 
    Document   : admin
    Created on : Apr 13, 2023, 3:43:10 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>

         <h1>WELCOME ${sessionScope.LOGIN_USER.fullname}</h1>
        <form action="mainController" method="post"> 
            <input type="text" name="txtsearch" value="${param.search}"/>
            <input type="submit" name="action" value="Search"/>
            <input type="submit" name="action" value="logout"/></br>
        </form>


        <c:if test="${requestScope.LIST_USER != null}">
            <c:if test="${not empty requestScope.LIST_USER}">

                <table border='1'>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>User ID</th>
                            <th>Full Name</th>
                            <th>Role ID</th>
                            <th>Password</th>
                            <th>Delete</th>
                            <th>Update</th>
                        </tr>
                    </thead>
                    <tbody>



                        <c:forEach var="userList" varStatus="counter" items="${requestScope.LIST_USER}">
                        <form action="mainController">


                            <tr>
                                <td>${counter.count}</td>
                                <td>${userList.userID} </td>
                                <td>
                                    <input type="text" name="fullname" value="${userList.fullname} "/>
                                </td>
                                <td>
                                    <input type="text" name="roleid" value="${userList.roleID}"  />
                                </td>
                                <td>${userList.password} </td>
                                <td>
                                    <a href="mainController?action=Delete&userid=${userList.userID}&txtsearch=${param.search}">Delete</a>
                                </td>
                                <td>
                                    <input type="hidden" name="userID" value="${userList.userID}"/>
                                    <input type="hidden" name="txtsearch" value="${param.search}"/>
                                    <input type="submit" name="action" value="Update"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>
            </table>


        </c:if>
        ${requestScope.ERROR}
    </c:if>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>
</html>
