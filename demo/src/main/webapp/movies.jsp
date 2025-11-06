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
</head>
<body>
<ul>

    <c:forEach var="movie" items="${(List<Movie>) request.getAttribute('movies')}">
    <li>
            <c:out value="${movie.getTitle() + ' (' + movie.getYear() + ')'}"/>
        </c:forEach>
        <%--            <% for (Movie movie : (List<Movie>) request.getAttribute("movies")) {%>--%>
        <%--    <li><%= movie.getTitle() + " (" + movie.getYear() + ")" %>--%>
        <%--    </li>--%>
        <%--    <% }%>--%>
</ul>
</body>
</html>
