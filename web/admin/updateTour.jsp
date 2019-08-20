<%-- 
    Document   : updateTour
    Created on : Feb 20, 2019, 9:53:40 PM
    Author     : Tammy Phan
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Tour</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/form.css">
        <style>
            table{
                width: 40%;
                margin-bottom: 300px;
            }
            img{
                width: 150px;
                height: 100px;
            }

        </style>
    </head>
    <body>
        <%@include file="/header.html" %>
        <c:set var="INVALID" value="${requestScope.INVALID}"/>
        <c:set var="dto" value="${requestScope.DTO}"/>
        <link rel="stylesheet" href="/ProjectPRJ321/css/form.css">
    <center>
        <h1>Update Tour</h1>
        <form action="/ProjectPRJ321/UpdateTourController" method="POST" enctype="multipart/form-data">
            <table>
                <tbody>
                    <tr>
                        <td class="label">Tour's id</td>
                        <td>
                            <input type="text" name="id" value="${dto.id}" readonly="true"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.idError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Title</td>
                        <td>
                            <input type="text" name="title" value="${dto.title}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.titleError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Capacity</td>
                        <td>
                            <input type="text" name="capacity" value="${dto.capacity}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.capacityError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Description </td>
                        <td>
                            <textarea name="description" rows="4" cols="80">${dto.description}</textarea>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.descriptionError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Price</td>
                        <td>
                            <input type="text" name="price" value="${dto.price}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.priceError}</td>
                    </tr>
                    <tr>
                        <td class="label">Start Date</td>
                        <td>
                            <input type="text" name="start_date" value="${dto.start_date}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.start_dateError}</td>
                    </tr>
                    <tr>
                        <td  class="label">End Date</td>
                        <td>
                            <input type="text" name="end_date" value="${dto.end_date}" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.end_dateError}</td>
                    </tr>
                    <tr>
                        <td  class="label">Image</td>
                        <td>
                            <img src="/ProjectPRJ321/img/${dto.img_url}" alt="${dto.img_url}"/>
                            <input type="hidden" name="img_url" value="${dto.img_url}" />
                        </td>
                    </tr>
                    <tr>
                        <td  class="label">Change Image</td>
                        <td>
                            <input type="file" name="file" />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2"style="color: red">${INVALID.img_urlError}</td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="hidden" name="txtSearch" value="${requestScope.SEARCH == null ? param.txtSearch : requestScope.SEARCH}" />
                            <input type="submit" value="Update"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </center>
</body>
</html>
