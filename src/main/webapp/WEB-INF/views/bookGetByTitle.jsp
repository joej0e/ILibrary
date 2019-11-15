<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Searching results</title>
</head>
<body>
<c:forEach var="book" items="${books}">
    <tr>
        <td>${book.id}</td>
        <td>${book.title}</td>
        <td>${book.price}</td>
    </tr>
</c:forEach>
</body>
</html>
