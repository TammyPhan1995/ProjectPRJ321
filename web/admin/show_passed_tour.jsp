<%-- 
    Document   : show_passed_tour
    Created on : Feb 28, 2019, 2:53:11 PM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Passed Tours</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <style>
            table{
                margin-bottom: 50px;
            }

        </style>
    </head>
    <body>
        <%@include file="/header.html" %>
    <center>

        <h1>PASSED TOUR</h1>
        <c:set  var="result" value="${requestScope.INFO}"/>
        <c:if test="${not empty result}">
            <table border="1">
                <thead>
                    <tr>
                        <th>No</th>
                        <th>Tour's id</th>
                        <th>Title</th>
                        <th>Booked Quantity</th>
                        <th>Start Date</th>
                        <th>End Date</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${result}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.id}</td>
                            <td>${dto.title}</td>
                            <td >${dto.booked_quantity}</td>
                            <td>${dto.start_date}</td>
                            <td>${dto.end_date}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <form action="/ProjectPRJ321/AdminMainController" method="POST">
                <input type="hidden" name="action" value="TourManagement" />
                <input type="hidden" name="subaction" value="DeletePassedTour" />
                <input style="width: 60%; " class="DeleteBtn" type="submit" value="Delete" />
            </form>
        </c:if>
        <c:if test="${empty result}">
            NO RECORD FOUND
        </c:if>
    </center>
</body>
</html>
