<%-- 
    Document   : showBooking
    Created on : Feb 27, 2019, 9:50:50 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer's Booking</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <style>
            table{
                width: 70%;
                margin-bottom: 100px;
            }
        </style>
    </head>

    <%@include file="/userHeader.jsp" %>
    <body>
    <center >
        <h1 id="title">${sessionScope.USER}'S BOOKINGS </h1>
        <c:set var="result" value="${requestScope.INFO}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Booking's id</th>
                        <th>Booked Date</th>
                        <th>Booked quantity</th>
                        <th>Price</th>
                        <th>Status</th>
                        <th>Cancel</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.booking_id}</td>
                            <td>${dto.booked_date}</td>
                            <td>${dto.quantity}</td>
                            <td>$${dto.price}</td>
                            <td>${dto.status}</td>
                            <c:set var="status" value="${dto.status}" />
                            <c:if test="${fn:contains(status,'paid')}">
                                <td>
                                    <form action="UserMainController" method="POST">
                                        <input type="hidden" name="booking_id" value="${dto.booking_id}" />
                                        <input type="hidden" name="quantity" value="${dto.quantity}" />
                                        <input type="hidden" name="action" value="TourManagement" />
                                        <input type="hidden" name="subaction" value="RejectTour" />
                                        <input class="DeleteBtn" type="submit" value="Cancel" />
                                    </form>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p style="color: red; font-family: Arial">${requestScope.ERROR}</p>
        </c:if>
        <c:if test="${empty result}">
            NO BOOKING
        </c:if>
    </center>
</body>
<%@include file="/footer.html" %>
</html>
