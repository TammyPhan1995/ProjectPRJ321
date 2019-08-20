<%--
    Document   : showCart
    Created on : Feb 28, 2019, 9:15:02 PM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer's Cart</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/tablecss.css">
        <style>
            table{
                margin-bottom: 50px;
            }
        </style>
    </head>

    <%@include file="/userHeader.jsp" %>
    <body style="font-family: Arial">
    <center>
        <h1>${sessionScope.USER}'s Cart</h1>
        <c:set var="cart" value="${sessionScope.CART}"/>
        <c:if test="${cart!=null}">
            <c:if test="${cart.total!=0}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>No</th>
                            <th>Tour's id</th>
                            <th>Title</th>
                            <th>Start Date</th>
                            <th>End Date</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${cart.cart.values()}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.tour_id}</td>
                                <td>${dto.title}</td>
                                <td>${dto.start_date}</td>
                                <td>${dto.end_date}</td>
                                <td>
                                    <form action="/ProjectPRJ321/UserMainController" method="POST">
                                        <select name="quantity" onchange="this.form.submit()">
                                            <c:forEach var="number" begin="1" end="${dto.available}">
                                                <option value="${number}" ${number == dto.quantity ? 'selected' : ''}>${number}</option>
                                            </c:forEach>
                                        </select>
                                        <input type="hidden" name="tour_id" value="${dto.tour_id}" />
                                        <input type="hidden" name="action" value="CartManagement" />
                                        <input type="hidden" name="subaction" value="Update" />
                                    </form>
                                </td>
                                <td>$${dto.price}</td>
                                <td>
                                    <form action="/ProjectPRJ321/UserMainController" method="POST">
                                        <input type="hidden" name="tour_id" value="${dto.tour_id}" />
                                        <input type="hidden" name="action" value="CartManagement" />
                                        <input class="DeleteBtn" type="submit" value="Delete" name="subaction" />
                                    </form>
                                </td>

                            </tr>

                        </c:forEach>
                        <tr>
                            <td colspan="7">Total</td>
                            <td>$${cart.total}</td>
                        </tr>
                        <tr>
                    <form action="/ProjectPRJ321/UserMainController" method="POST">
                        <td colspan="8" style=" background-color: white">
                            Promotion Code: <input id="codeInput" type="text" name="promotion_code" value="" />
                        </td>
                        </tr>
                        <tr>
                            <td colspan="8" style="text-align: center; background-color: white" >

                                <input type="hidden" name="action" value="BookingManagement" />
                                <input type="hidden" name="subaction" value="Insert" />
                                <input id="checkoutBtn"type="submit" value="Check Out"/>
                    </form>
                    </td>
                    </tr>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${cart.total==0}">
                EMPTY CART
            </c:if>
        </c:if>
        <c:if test="${cart==null}">
            EMPTY CART
        </c:if>
        <font color="red">
        ${requestScope.INVALID}
        </font>
        <br/>
        <a class="homeLink" href="/ProjectPRJ321/user/showProducts.jsp" >Go Back For Shopping</a>
    </center>
</body>
<%@include file="/footer.html" %>
</html>
