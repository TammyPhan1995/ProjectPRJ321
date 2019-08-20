<%-- 
    Document   : viewPromotion
    Created on : Mar 15, 2019, 10:52:42 AM
    Author     : Tammy Phan
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Promotion</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/promotion.css">
    </head>
    <body>
        <%@include file="/userHeader.jsp" %>
    <center>
        <img src="/ProjectPRJ321/img/sale.jpg" />
        <c:set var="result" value="${requestScope.INFO}"/>
        <c:if test="${result!=null}">
            <h1 id="title">PROMOTION CODES</h1>
            <c:if test="${not empty result}">
                <c:forEach var="dto" items="${result}">
                    <div class="proContainer">
                        <h2>${dto.promotion_code}</h2>
                        <h3>${dto.content}</h3>
                        <h1 class="percentage"><fmt:formatNumber  maxFractionDigits="3" value="${dto.value*100}"/>%</h1>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty result}">
                <p style="margin-top: 10px; font-family: Arial">NO PROMOTION AVAILABLE</p>
            </c:if>
        </c:if>
    </center>
    `<%@include file="/footer.html" %>
</body>
</html>
