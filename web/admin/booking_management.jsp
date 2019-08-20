<%-- 
    Document   : booking_management
    Created on : Feb 19, 2019, 9:00:58 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's Booking Management</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <link rel="stylesheet" href="/ProjectPRJ321/css/searchForm.css">
        <script src="/ProjectPRJ321/js/searchJS.js"></script>

    </head>
    <body>
        <%@include file="/header.html" %>
    <center><h1>BOOKING MANAGEMENT</h1>
        <form name="searchForm" action="/ProjectPRJ321/AdminMainController" method="POST" onsubmit="return checkValid()">
            <div id="searchDiv">
                <input type="text" name="txtSearch" value="${param.txtSearch}" placeholder="Username or tour's id "/>
                <input type="hidden" name="action" value="BookingManagement" />
                <input type="hidden" name="subaction" value="SearchBookingForAdmin" />
                <input id="searchBtn" type="submit"  value="Search" />
            </div>
        </form>
        <c:set var="result" value="${requestScope.INFO}"/>
        <c:if test="${result!=null}">
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Booking's id</th>
                            <th>Booked Date</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Status</th>
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
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${empty result}">
                <p style="margin-top: 10px;">NOT RECORD FOUND</p>
            </c:if>
        </c:if>
    </center>

</body>
</html>
