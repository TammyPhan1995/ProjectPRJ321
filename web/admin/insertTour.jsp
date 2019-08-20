<%-- 
    Document   : insertTour
    Created on : Feb 19, 2019, 9:21:27 PM
    Author     : Tammy Phan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Tour</title>
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
        <c:set var="INVALID" value="${requestScope.INVALID}"/>
        <c:set var="params" value="${requestScope.PARAMS}"/>
    <center>
        <h1>Insert Tour</h1>
        <form action="/ProjectPRJ321/InsertTourController" method="POST" enctype="multipart/form-data">
            <table>
                <tbody>
                    <tr>
                        <td  class="label">Tour's id</td>
                        <td>
                            <input type="text" name="id" value="${params.get("id")}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.idError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Title</td>
                        <td>
                            <input type="text" name="title" value="${params.get("title")}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.titleError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Capacity</td>
                        <td>
                            <input type="text" name="capacity" value="${params.get("capacity")}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.capacityError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Description</td>
                        <td>
                            <textarea name="description" rows="4" cols="80">${params.get("description")}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.descriptionError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Price</td>
                        <td>
                            <input type="text" name="price" value="${params.get("price")}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.priceError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Start Date</td>
                        <td>
                            <input type="text" name="start_date" value="${params.get("start_date")}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.start_dateError}</td>
                    </tr>
                    <tr>
                        <td  class="label">End Date</td>
                        <td>
                            <input type="text" name="end_date" value="${params.get("end_date")}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.end_dateError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Image </td>
                        <td>
                            <input type="file" name="file" value="" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.img_urlError}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="Insert" />
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>
