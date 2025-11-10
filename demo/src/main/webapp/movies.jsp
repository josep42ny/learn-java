<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.github.josep42ny.demo.model.Movie" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: alumati
  Date: 6/11/25
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
<table>
    <thead>
        <tr>
            <th>Id</th>
            <th>Title</th>
            <th>Synopsis</th>
            <th>Year</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${movies != null}">
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.id}</td>
                    <td>${movie.title}</td>
                    <td>${movie.description}</td>
                    <td>${movie.year}</td>
                </tr>
            </c:forEach>
        </c:if>
    </tbody>
</table>
<ul>
    <c:if test="${movies == null}">
        <li>
            No movie found.
        </li>
    </c:if>
</ul>
</body>
</html>
