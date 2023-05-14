<%-- 
    Document   : shopping
    Created on : Apr 17, 2023, 3:11:58 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dto.User"%>
<%@page import="sample.dto.Product"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <h1>MENU MILK TEA</h1>
        <form action="mainController">
            <input type="submit" name="action" value="getall"/>
            <input type="submit" name="action" value="viewcart"/>
            <input type="submit" name="action" value="logout"/></br>
        </form>
        <c:if test="${requestScope.LIST_PRODUCT != null}">
            <c:if test="${not empty requestScope.LIST_PRODUCT}">


                <table border='1'>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Product ID</th>
                            <th>Full Name</th>
                            <th>price</th>
                            <th>quantity</th>
                            <th>Add</th>

                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="product" varStatus="counter" items="${requestScope.LIST_PRODUCT}">


                        <form action="mainController" method="POST">
                            <tr>
                            <h3><td>${counter.count}</td></h3>
                                <td>${product.productID}</td>

                                <td>${product.name}</td>

                                <td>
                                    <input name="price" value="${product.price}"/>
                                </td>
                                <td>
                                    <input type="number" name="quantity" value="1" min="1" max="${product.quantity}"/>
                                </td>
                                <td>
                                    <input type="submit" name="action" value="Add"/>
                                    <input type="hidden" name="productID" value="${product.productID}"/>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                </tbody>

            </table>

            ${requestScope.MESSAGE}
        </c:if>
    </c:if>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>
</html>
