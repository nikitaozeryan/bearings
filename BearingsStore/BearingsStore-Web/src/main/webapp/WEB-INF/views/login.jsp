<%-- 
    Document   : login
    Created on : 10.10.2016, 23:40:12
    Author     : Никита
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="login">
            <input type="text" name="user"/>
            <input type="password" name="pass"/>
            <input type="submit" name="submit" value="login"/>
        </form>
    </body>
</html>
