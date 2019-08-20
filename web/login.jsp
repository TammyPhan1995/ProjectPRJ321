<%-- 
    Document   : login
    Created on : Feb 19, 2019, 8:29:17 AM
    Author     : Tammy Phan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
        <link rel="stylesheet" href="/ProjectPRJ321/css/logincss.css">
        <link rel="stylesheet" href="/ProjectPRJ321/css/form.css">
    </head>
    <body>
        <div id="mainContainer">
            <center>
            <h1>RACOON Traveling</h1>
            <span style="color: red">${requestScope.ERROR}</span><br/>
            <form action="LoginController" method="POST">
                <table>
                    <tr>
                        <td class="label" >USERNAME</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="username" /></td>
                    </tr>
                     <tr>
                        <td class="label" >PASSWORD</td>
                    </tr>
                    <tr>
                        <td><input type="password" name="password"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="LOGIN" /></td>
                    </tr>
                </table>
            </form>
            <a href="user/insertUser.jsp">Create New Account</a>
            </center>
        </div>
 

</body>
</html>
