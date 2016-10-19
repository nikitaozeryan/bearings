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
        <table>
            <tr class="table-head">
                <td>id</td>
                <td>firstname</td>
                <td>lastname</td>
                <td>login</td>
                <td>email</td>
                <td>phone</td>
                <td>edit</td>
                <td>remove</td>
            </tr>
            
            <c:forEach var="u" items="${users}">
                <tr class="table-data" id="${u.id}">
                    <td>${u.id}</td>
                    <td>${u.firstname}</td>
                    <td>${u.lastname}</td>
                    <td>${u.login}</td>
                    <td>${u.email}</td>
                    <td>${u.phone}</td>
                    <td>
                        <a href="edituser?id=${u.id}">
                            edit
                        </a>
                    </td>
                    <td>
                        <a href="deleteuser?id=${u.id}" onclick="return deleteUserById(${u.id})">
                            remove
                        </a>
                    </td>
                </tr>
            </c:forEach>
                
        </table>
        <a href="adduser">Add new Pupkin</a>
        <a href="logout" >logout</a>
        
    </body>
</html>
