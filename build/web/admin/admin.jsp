<%-- 
    Document   : admin
    Created on : Feb 19, 2019, 8:42:31 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's Dashboard</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/dashboard.css">
    </head>
    <body onload="move()">
        <%@include file="/header.html" %>
    <center> 
        <table border="1">
            <tbody>
                <tr>
                    <th>User Management</th>
                </tr>
                <tr>
                    <td><a href="/ProjectPRJ321/admin/user_management.jsp">Search users by full name to delete</a></td>
                </tr>

                <tr>
                    <th>Tour Management</th>
                </tr>
                <tr>
                    <td><a href="/ProjectPRJ321/admin/insertTour.jsp">Add new tour</a></td>
                </tr>
                <tr>
                    <td><a href="/ProjectPRJ321/admin/tour_management.jsp">Search tours by title to delete or update</a></td>
                </tr>
                <tr>
                    <c:url var="deleteOverdueTourLink" value="/AdminMainController">
                        <c:param name="action" value="TourManagement"/>
                        <c:param name="subaction" value="CheckPassedTour" />
                    </c:url>
                    <td><a href="${deleteOverdueTourLink}">Delete passed tours</a></td>
                </tr>
            <th>Promotion Management</th>
            </tr>
            <tr>
                <td><a href="/ProjectPRJ321/admin/insertPromotion.jsp">Add new promotion</a></td>
            </tr>
            <tr>
                <c:url var="viewPromotionLink" value="/AdminMainController">
                    <c:param name="action" value="PromotionManagement"/>
                    <c:param name="subaction" value="Search" />
                </c:url>
                <td><a href="${viewPromotionLink}">View promotions</a></td>
            </tr>
            <tr>
                <th>Booking Management</th>
            </tr>
            <tr>
                <td><a href="/ProjectPRJ321/admin/booking_management.jsp" >Search bookings</a></td>
            </tr>
            </tbody>
        </table>

    </center>
    <img class="message" id="chatBoxImage" alt="chatBax" src="/ProjectPRJ321/img/chatBox.png"/>
    <h2 id="messageStr" class="message">Welcome ${sessionScope.USER}</h2>
    <h3 id="messageStr2" class="message">  Please check passed tours <br/>regularly</h3>

</body>
</html>
