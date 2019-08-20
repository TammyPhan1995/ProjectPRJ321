<%-- 
    Document   : insertUser
    Created on : Feb 26, 2019, 9:47:04 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add New Account</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/form.css">
        <style>
            table{
                width: 50%;
            }
        </style>
    </head>
    <body>
        <c:set var="INVALID" value="${requestScope.INVALID}"/>
    <center>
        <h1 id="title">REGISTER</h1>
        <form action="/ProjectPRJ321/UserMainController" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td class="label" >Username</td>
                        <td>
                            <input type="text" name="id" value="${param.id}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.idError}</td>
                    </tr>
                    <tr>
                        <td class="label">Password</td>
                        <td>
                            <input type="password" name="password" value="${param.password}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.passwordError}</td>
                    </tr>
                    <tr>
                        <td class="label">Confirm Password</td>
                        <td>
                            <input type="password" name="confirm" value="${param.confirm}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.confirmError}</td>
                    </tr>
                    <tr>
                        <td class="label">Full Name</td>
                        <td>
                            <input type="text" name="fullname" value="${param.fullname}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.fullnameError}</td>
                    </tr>
                    <tr>
                        <td class="label">Email</td>
                        <td>
                            <input type="text" name="email" value="${param.email}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.emailError}</td>
                    </tr>
                    <tr>
                        <td class="label">Phone</td>
                        <td>
                            <input type="text" name="phone" value="${param.phone}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.phoneError}</td>
                    </tr>
                    <tr>
                        <td class="label">Date of birth<br/> (yyyy-mm-dd)</td>
                        <td>
                            <input type="text" name="dob" value="${param.dob}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.dobError}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="action" value="UserManagement" />
                            <input type="submit" value="Register" name="subaction" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        <a href="/ProjectPRJ321/login.jsp">Back To Login Page</a>
    </center>
</body>

</html>
