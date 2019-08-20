<%-- 
    Document   : updateUser
    Created on : Feb 26, 2019, 10:06:27 PM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update User's Profile</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/form.css">
        <style>
            table{
                width: 50%;
            }
        </style>
    </head>
    <body>
        <%@include file="/userHeader.jsp" %>
        <c:set var="INVALID" value="${requestScope.INVALID}" />
        <c:set var="dto" value="${requestScope.DTO}"/>
    <center>
        <h1 id="title">UPDATE PROFILE</h1>
        <form action="/ProjectPRJ321/UserMainController" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td class="label">Username</td>
                        <td>
                            <input type="text" name="id" value="${dto.id}"  readonly="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="label">Full Name</td>
                        <td>
                            <input type="text" name="fullname" value="${dto.fullname}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.fullnameError}</td>
                    </tr>
                    <tr>
                        <td class="label">Email</td>
                        <td>
                            <input type="text" name="email" value="${dto.email}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.emailError}</td>
                    </tr>
                    <tr>
                        <td class="label">Phone</td>
                        <td>
                            <input type="text" name="phone" value="${dto.phone}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.phoneError}</td>
                    </tr>
                    <tr>
                        <td class="label">Date of birth <br/>(yyyy-mm-dd)</td>
                        <td>
                            <input type="text" name="dob" value="${dto.dob}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.dobError}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="action" value="UserManagement" />
                            <input type="submit" value="Update" name="subaction" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
<%@include file="/footer.html" %>
</html>
