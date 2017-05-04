<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 3/31/2017
  Time: 10:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="2">
<thead align="center">
<tr>

    <td>
    ID
    </td>
    <td>
    Username
    </td>
    <td>
    Email
    </td>
    <td>
    Password
    </td>


</tr>
</thead>

<c:forEach var="model" items="${model}" >
<tbody>
<tr>

    <td>${model.id}</td>
    <td>${model.username}.</td>
    <td>${model.email}.</td>
    <td>${model.password}.</td>
    <td><a class="btn btn-success" href="/itncontroller/update?editid=${model.id}&action=update">Update!</a></td>
    <td><a class="btn btn-success" href="/itncontroller/update?editid=${model.id}&action=delete">Delete!</a></td>

</tr>
</tbody>
</c:forEach>


</table>


</body>
</html>
