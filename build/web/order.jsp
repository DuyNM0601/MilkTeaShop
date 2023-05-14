<%-- 
    Document   : order
    Created on : Apr 19, 2023, 3:29:37 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dto.orderDetail"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sample.dto.Order"%>
<%@page import="sample.dto.User"%>
<%@page import="sample.dto.Cart"%>
<%@page import="sample.dto.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
      
     
        <h1>ORDER DETAILS</h1>
        <table border='1' style='width: 25%; height: 50px; font-size: 16px'>
            <thead>
                <tr>
                    <th>Order ID</th>
                    <th>Product ID</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
            </thead>
            <tbody>
            <form action="mainController">
                <input type="submit" name="action" value="logout"/></br>
            </form>
           
            <c:forEach var="orderDetail" items="${requestScope.ORDER_LIST}">
                
           
            <form action="mainController" method="post">
                <tr>
                <h3><td style="font-size: 16px;">${orderDetail.orderID}</td></h3>
                <h3><td style="font-size: 16px;">${orderDetail.productID}</td></h3>
                <h3><td style="font-size: 16px;">${orderDetail.quantity}</td></h3>
                <h3><td style="font-size: 16px;">${orderDetail.price}</td></h3>
                    



                    <!--edit card o day-->

                </tr>
            </form>
            
             </c:forEach>
        </tbody>
    </table>
</body>
<a href="mainController?action=getall">Add more</a>
<footer>
    <%@include file="footer.jsp" %>
</footer>
</html>
