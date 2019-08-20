<%-- 
    Document   : userHeader
    Created on : Mar 10, 2019, 7:54:15 PM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User's Header</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/userHeader.css"/>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    </head>
    <body>
        <div id="header">
            <a href="/ProjectPRJ321/user/showProducts.jsp" title="Click me to back to dashboard"><img alt="raccoon" id="headerImage" src="/ProjectPRJ321/img/logo.png"/></a>
            <h1>RACCOON Traveling</h1>
            <h5 id="welcomeStatus">Welcome ${sessionScope.USER}</h5>
        </div>
        <div class="navbar">
            <a class="inNavLink" href="/ProjectPRJ321/user/showProducts.jsp">Home</a>
             <c:url var="viewPromotionLink" value="/UserMainController">
                 <c:param name="action" value="PromotionManagement"/>
                 <c:param name="subaction" value="CustomerView" />
             </c:url>
            <a   class="inNavLink" href="${viewPromotionLink}">Promotion</a>
            <div class="dropdown">
                <button class="dropbtn">My Account 
                    <i class="fa fa-caret-down"></i>
                </button>
                <div class="dropdown-content">
                    <c:url var="editProfileLink" value="http://localhost:8084/ProjectPRJ321/UserMainController">
                        <c:param name="action" value="UserManagement" />
                        <c:param name="subaction" value="Edit"/>
                        <c:param name="id" value="${sessionScope.USER}"/>
                    </c:url>
                    <a href="${editProfileLink}">Profile</a>
                    <c:url var="showBookingLink" value="http://localhost:8084/ProjectPRJ321/UserMainController" >
                        <c:param name="action" value="BookingManagement"/>
                        <c:param name="subaction" value="SearchBookingForUser" />
                    </c:url>
                    <a href="${showBookingLink}">Booking</a>
                    <a href="/ProjectPRJ321/LogoutController">Logout</a>
                </div>
            </div>
        </div>
        <a href="/ProjectPRJ321/user/showCart.jsp" id="aa">
            <i class="fa">&#xf07a;</i>
        </a>
    </body>
</html>
