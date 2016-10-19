<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
        <script type="text/javascript" src="https://code.jquery.com/jquery-3.0.0.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <ul>
            <c:forEach var="err" items="${errors}">
                <li>${err}</li>
            </c:forEach>
        </ul>
        <form action="adduser" method="post">
            <table>
                <tr>
                    <td>firstname</td>
                    <td>
                        <input type="text" name="firstname" value="${firstname}"/>
                    </td>
                </tr>
                <tr>
                    <td>lastname</td>
                    <td><input type="text" name="lastname" value="${lastname}"/></td>
                </tr>
                <tr>
                    <td>login</td>
                    <td><input type="text" name="login" value="${login}"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" value="${email}"/></td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td><input type="text" name="phone" value="${phone}"/></td>
                </tr>
                <tr class="submit-row">
                    <td colspan="2">
                        <input type="submit" name="submit" value="Sign Up" />
                    </td>
                </tr>
            </table>        
        </form>
    </body>
</html>
