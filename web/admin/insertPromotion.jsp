<%-- 
    Document   : insertPromotion
    Created on : Mar 15, 2019, 9:21:34 AM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Promotion</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/form.css">
        <style>
            table{
                width: 40%;
                margin-bottom: 300px;
            }
        </style>
    </head>
    <body>
        <%@include file="/header.html" %>
        <c:set var="INVALID" value="${requestScope.INVALID}" />
    <center>
        <h1>INSERT PROMOTION</h1>
        <form action="/ProjectPRJ321/AdminMainController" method="POST">
            <table>
                <tbody>
                    <tr>
                        <td class="label">Promotion Code</td>
                        <td>
                            <input type="text" name="promotion_code" value="${param.promotion_code}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.codeError}</td>
                    </tr>
                     <tr>
                        <td class="label">Content</td>
                        <td>
                            <textarea name="content" rows="4" cols="55">${param.content}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" style="color: red">${INVALID.contentError}</td>
                    </tr>
                    <tr>
                        <td class="label">Value</td>
                        <td>
                            <select name="value">
                                <option value="0.1" ${param.value == 0.1 ? 'selected' : ''}>10%</option>
                                <option value="0.2" ${param.value == 0.2 ? 'selected' : ''}>20%</option>
                                <option value="0.3" ${param.value == 0.3 ? 'selected' : ''}>30%</option>
                                <option value="0.4" ${param.value == 0.4 ? 'selected' : ''}>40%</option>
                                <option value="0.5" ${param.value == 0.5 ? 'selected' : ''}>50%</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"> 
                            <input type="submit" value="Insert" name="subaction" />
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="hidden" name="action" value="PromotionManagement" />
        </form>
    </center>
    </body>
</html>
