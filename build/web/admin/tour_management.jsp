<%-- 
    Document   : tour_management
    Created on : Feb 19, 2019, 9:00:39 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's Tour Management</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <link rel="stylesheet" href="/ProjectPRJ321/css/searchForm.css">
        <script src="/ProjectPRJ321/js/searchJS.js"></script>
        
    </head>
    <body>
        <%@include file="/header.html" %>
    <center><h1>TOUR MANAGEMENT</h1>
        <form name="searchForm" action="/ProjectPRJ321/AdminMainController" method="POST" onsubmit="return checkValid()">
            <div id="searchDiv">
                <span class="label">Title:</span> <input type="text" name="txtSearch" value="${param.txtSearch}" />
                <input type="hidden" name="action" value="TourManagement" />
                <input id="searchBtn" type="submit"  value="Search" name="subaction"/>
            </div>
        </form>
        <c:set var="result" value="${requestScope.INFO}"/>
        <c:if test="${result!=null}">
            <c:if test="${not empty result}">
                <table>
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Tour's id</th>
                            <th>Title</th>
                            <th>Capacity</th>
                            <th>Price</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Booked quantity</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.title}</td>
                                <td style="text-align: center">${dto.capacity}</td>
                                <td>$${dto.price}</td>
                                <td>${dto.start_date}</td>
                                <td>${dto.end_date}</td>
                                <td style="text-align: center">${dto.booked_quantity}</td>
                                <td>
                                    <form action="/ProjectPRJ321/AdminMainController" method="POST">
                                        <input type="hidden" name="id" value="${dto.id}" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                        <input type="hidden" name="action" value="TourManagement" />
                                        <input class="EditBtn" type="submit" value="Edit" name="subaction" />
                                    </form>
                                </td>
                                <td>
                                    <form action="/ProjectPRJ321/AdminMainController" method="POST">
                                        <input type="hidden" name="id" value="${dto.id}" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                        <input type="hidden" name="action" value="TourManagement" />
                                        <input class="DeleteBtn" type="submit" value="Delete" name="subaction" />
                                    </form>
                                </td>
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
