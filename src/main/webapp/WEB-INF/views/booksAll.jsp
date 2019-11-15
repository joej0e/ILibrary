<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>All books</title>
</head>
<body>
<table border="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach var="book" items="${books}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>
