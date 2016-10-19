<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css"/>
    </head>
    <body>
        <ul>
            <c:forEach var="err" items="${errors}">
                <li>${err}</li>
            </c:forEach>
        </ul>
        <form action="edituser" method="post">
            <input type="hidden" name="id" value="${user.id}"/>
            <table>
                <tr>
                    <td>firstname</td>
                    <td>
                        <input type="text" name="firstname" value="${user.firstname}"/>
                    </td>
                </tr>
                <tr>
                    <td>lastname</td>
                    <td><input type="text" name="lastname" value="${user.lastname}"/></td>
                </tr>
                <tr>
                    <td>email</td>
                    <td><input type="text" name="email" value="${user.email}"/></td>
                </tr>
                <tr>
                    <td>phone</td>
                    <td><input type="text" name="phone" value="${user.phone}"/></td>
                </tr>
                <tr class="submit-row">
                    <td colspan="2">
                        <input type="submit" name="submit" value="Edit user" />
                    </td>
                </tr>
            </table>        
        </form>
    </body>
</html>
