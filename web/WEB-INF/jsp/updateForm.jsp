<%--
  Created by IntelliJ IDEA.
  User: Ruzal
  Date: 3/29/2017
  Time: 11:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="/itncontroller/insert">
    <table>
        <tr>
            <td>

                <label>Username :</label>
            </td>
            <td>

                <input type="text" name="username" placeholder=" Enter your name!"/>
            </td>
        </tr>

        <tr>
            <td>
                <label>Email : </label>
            </td>
            <td>
                <input type="email" name="email" placeholder="Enter Email"/>
            </td>
        </tr>
        <tr>
            <td>
                <label>
                    Password :
                </label>
            </td>
            <td>
                <input type="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="update" name="button" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>
