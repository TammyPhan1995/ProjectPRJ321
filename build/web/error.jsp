<%-- 
    Document   : error
    Created on : Feb 19, 2019, 8:42:59 AM
    Author     : Tammy Phan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR Page</title>
    </head>
    <style>
        img{
             visibility: hidden;
        }
        h2{
            color: red;
                   }
        #errorImg{
            margin-top: 100px;
        }
    </style>
    <body>
        <%@include file="header.html" %>
    <center>
        <h1>ERROR PAGE</h1>
        <center>
        <h2>
            ${requestScope.ERROR}
        </h2>
        </center>
        <img id="errorImg"style="visibility: visible" src="/ProjectPRJ321/img/error.jpg"/>
    </center>
    </body>
</html>
