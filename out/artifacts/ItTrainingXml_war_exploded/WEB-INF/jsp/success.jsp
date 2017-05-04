<%@ page import="DAO.ITNDao" %>
<%@ page import="Model.ITNModel" %>
<%@ page import="org.springframework.ui.ModelMap" %><%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 3/29/2017
  Time: 11:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead align="center">Your Details.</thead>
    <tr>
        <th>Username</th>

        <th>Email</th>

        <th>Password</th>
    </tr>

    <%--<c:forEach var="model" items="${model}" >--%>

    <tr>
     <td>${model.username}.</td>
    <td>${model.email}.</td>
    <td>${model.password}.</td>

    </tr>

    <%--</c:forEach>--%>


</table>

<form action="/itncontroller/display" method="get">
    <input type="submit" value="view">

</form>


</body>
</html>
