<%-- 
    Document   : user_management
    Created on : Feb 19, 2019, 9:00:23 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's User Management</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <link rel="stylesheet" href="/ProjectPRJ321/css/searchForm.css">
        <script src="/ProjectPRJ321/js/searchJS.js"></script>

    </head>
    <body>
        <%@include file="/header.html" %>
    <center><h1>USER MANAGEMENT</h1>
        <form name="searchForm" action="/ProjectPRJ321/AdminMainController" method="POST" onsubmit="return checkValid()">
            <div id="searchDiv" >
                <span class="label">Full Name:</span> <input type="text" name="txtSearch"value="${param.txtSearch}"/>
                <input type="hidden" name="action" value="UserManagement" />
                <input  type="hidden" name="subaction" value="Search" />
                <input id="searchBtn" type="submit"  value="Search">
            </div>
        </form>
        <c:set var="result" value="${requestScope.INFO}"/>
        <c:if test="${result!=null}">
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>UserID</th>
                            <th>Fullname</th>
                            <th>Email</th>
                            <th>Phone</th>
                            <th>DOB</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.id}</td>
                                <td>${dto.fullname}</td>
                                <td>${dto.email}</td>
                                <td>${dto.phone}</td>
                                <td>${dto.dob}</td>
                                <td>
                                    <form action="/ProjectPRJ321/AdminMainController" method="POST">
                                        <input type="hidden" name="id" value="${dto.id}" />
                                        <input type="hidden" name="txtSearch" value="${param.txtSearch}" />
                                        <input type="hidden" name="action" value="UserManagement" />
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
