<%-- 
    Document   : user
    Created on : Feb 19, 2019, 8:42:49 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Products For User</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/user.css" />
    </head>
    <body>
        <%@include file="/userHeader.jsp" %>
    <center>
        <img id="introImg" src="/ProjectPRJ321/img/ruong.jpg" >
        <div id="sloganContainer">
            We HERE<br/>
            To Get You THERE
        </div>
        <span id="title">Upcoming Tours</span>
        <div id="bodyContainer">
            <c:set var="result" value="${requestScope.INFO}"/> 
            <c:if test="${not empty result}">
                <c:forEach var="dto" items="${result}">
                    <div class="productContainer" >
                        <div class="imgContainer">
                            <img class="productImage" src="/ProjectPRJ321/img/${dto.img_url}"  alt="${dto.img_url}"/>
                        </div>
                        <div class="infoContainer">
                            <h2>${dto.title}</h2>
                            <h3>${dto.id}</h3>
                            <p>From: ${dto.start_date} to: ${dto.end_date}<br/><br/>
                                <span class="description"> ${dto.description}</span> </p>
                            <p style="font-weight: bold">Available seat: ${dto.capacity - dto.booked_quantity} </p><br/>
                            <p style="font-weight: bold">Price: $${dto.price}</p><br/>
                        </div>
                        <form action="/ProjectPRJ321/UserMainController" method="POST">
                            <input type="hidden" name="tour_id" value="${dto.id}" />
                            <input type="hidden" name="title" value="${dto.title}" />
                            <input type="hidden" name="price" value="${dto.price}" />
                            <input type="hidden" name="start_date" value="${dto.start_date}" />
                            <input type="hidden" name="end_date" value="${dto.end_date}" />
                            <input type="hidden" name="available" value="${dto.capacity-dto.booked_quantity}" />
                            <input type="hidden" name="action" value="CartManagement" />
                            <input id="${dto.id}" class="AddCartBtn" type="submit" value="Add To Cart" name="subaction" />
                        </form>
                    </div>
                    <c:if test="${(dto.capacity-dto.booked_quantity)==0}">

                        <script>
                            var btn = document.getElementById("${dto.id}");
                            btn.disabled = "true";
                            btn.style.backgroundColor = "black";
                            btn.value = "SOLD OUT";
                        </script>
                    </c:if>
                </c:forEach>
            </c:if>
            <c:if test="${empty result}">
                NO TOUR AVAILABLE
            </c:if>
        </div>
    </center>
    <%@include file="/footer.html" %>
</body>
</html>
