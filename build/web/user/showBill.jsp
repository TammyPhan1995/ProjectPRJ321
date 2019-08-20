<%-- 
    Document   : showBill
    Created on : Mar 2, 2019, 10:45:59 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer's Bill</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <style>
            table{
                margin-bottom: 50px;
            }
        </style>
    </head>
    <%@include file="/userHeader.jsp" %>
    <body style="font-family: Arial">
    <center>
        <h2 id="title">INVOICE</h2>
        <c:set var="cart" value="${requestScope.CART}"/>
        <h3>Username: ${sessionScope.USER}</h3>
        <h3>DATE: ${requestScope.DATE}</h5>
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Tour's id</th>
                        <th>Title</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                        <th>Quantity</th>
                        <th>Unit Price</th>
                        <th>Total</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${cart.cart.values()}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${item.tour_id}</td>
                            <td>${item.title}</td>
                            <td>${item.start_date}</td>
                            <td>${item.end_date}</td>
                            <td>${item.quantity}</td>
                            <td>$${item.price}</td>
                            <td>$${item.quantity * item.price}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td colspan="7">TOTAL:</td>
                        <td>$${cart.total}</td>
                    </tr>
                    <tr>
                        <td colspan="7">PROMOTION:</td>
                        <td><fmt:formatNumber maxFractionDigits="3" value="${cart.promotion_value*100}" />%</td>
                    </tr>
                    <tr>
                        <td colspan="7">TOTAL DUE:</td>
                        <td>$${cart.totalDue}</td>
                    </tr>

                    <tr>
                        <td colspan="8" style="color: red; background-color: white">
                            If your ticket was purchased during the 7 day period before tour's start day, <br/>
                            there will be no refund. Otherwise, you can request for a 50% of total payment refund before the 7 day period.
                        </td>
                    </tr>
                </tbody>
            </table>

            <h1 style="font-family: Arial">Thank You For Shopping</h1>
            <img src="/ProjectPRJ321/img/love.png" width="100" height="150"/> 
            <br/>
            <a class="homeLink" href="/ProjectPRJ321/user/showProducts.jsp">Go Back To Home Page</a>
    </center>
</body>
<%@include file="/footer.html" %>
</html>
