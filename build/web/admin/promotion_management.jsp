<%-- 
    Document   : promotion_management
    Created on : Mar 15, 2019, 9:21:11 AM
    Author     : Tammy Phan
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin's Promotion Management</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <link rel="stylesheet" href="/ProjectPRJ321/css/searchForm.css">
    </head>
    <body>
        <%@include file="/header.html" %>
    <center><h1>PROMOTION MANAGEMENT</h1>
        <c:set var="result" value="${requestScope.INFO}"/>
        <c:if test="${result!=null}">
            <c:if test="${not empty result}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Promotion Code</th>
                            <th>Value</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${result}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.promotion_code}</td>
                                <td><fmt:formatNumber  maxFractionDigits="3" value="${dto.value*100}"/>%</td>
                                <td>
                                    <form action="/ProjectPRJ321/AdminMainController" method="POST">
                                        <input type="hidden" name="code" value="${dto.promotion_code}" />
                                        <input type="hidden" name="action" value="PromotionManagement" />
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
