<%-- 
    Document   : viewcart
    Created on : Apr 17, 2023, 4:45:54 PM
    Author     : duy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="sample.dto.Product"%>
<%@page import="sample.dto.Cart"%>
<%@page import="sample.dto.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ViewCart Page</title>
    </head>
    <body>
        <header>
            <%@include file="header.jsp" %>
        </header>
        <h1>Your shopping cart</h1>
        <c:if test="${sessionScope.CART != null}">


            <table border='1'>
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Product ID</th>
                        <th>Full Name</th>
                        <th>Price</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Edit</th>
                        <th>Remove</th>
                    </tr>
                </thead>

                <tbody>

                    <c:forEach var="product" varStatus="counter" items="${sessionScope.CART.cart.values()}">


                    <form action="mainController" method="post">
                        <tr>
                            <td>${counter.count}</td>
                            <td><input  type="text" name="productID" value="${product.productID}" readonly=""</td>               
                            <td>${product.name}</td>

                            <td><input type="text" name="price" value="$${product.price}"/> </td>
                            <td>
                                <input type="number" name="quantity" value="${product.quantity}" required="" />
                            </td>

                            <td>
                                ${product.price*product.quantity}
                                <c:set var="total" value="${product.price * product.quantity + total}"></c:set>
                                </td>
                                <!--edit card o day-->
                                <td>
                                    <input type="submit" name="action" value="edit"/>
                                </td>
                                <td>
                                    <input type="submit" name="action" value="remove"/>
                                </td>
                                
                            </tr>
                        </form>
                </c:forEach>
            </tbody>
        </table>
        <h3>Total:${total}</h3>    
        <h5>${requestScope.ERROR}</h5>
        <h5>${requestScope.MESSAGE1}</h5>
        
    </c:if>
        <form action="mainController" method="post">           
            <input type="hidden" name="userID" value="${sessionScope.LOGIN_USER.userID}"/>  
        <input type="submit" name="action" value="Order"/>
        <input type="submit" name="action" value="Order Details"/>
        <input type="submit" name="action" value="logout"/></br>
    </form>


<h3>${requestScope.MESSAGE2}</h3>
    <a href="mainController?action=getall">Add more</a>
    <footer>
        <%@include file="footer.jsp" %>
    </footer>
</body>
</html>
