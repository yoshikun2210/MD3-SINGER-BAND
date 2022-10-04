<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2022
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1><%= "------------SINGER MANAGE--------------" %>
</h1>
<br/>
<a href="singer?action=create">Create Singer</a>
<form method="post">
    <input type="text" name="search">
    <button type="submit">Search</button>
</form>
<table border="1" style="width: 100%">
    <tr>
        <th>STT</th>
        <th>NAME</th>
        <th>AGE</th>
        <th>SEX</th>
        <th>DELETE</th>
        <th>EDIT</th>
    </tr>
</table>
<c:forEach var="st" items='${requestScope["listSinger"]}'>
    <tr>
        <td><a href="students?action=detail&id=${st.id}">${st.id}</a></td>
        <td>${st.name}</td>
        <td>${st.age}</td>
        <td>${st.sex}</td>

        <td>
            <a href="singer?action=edit&id=${st.id}">Edit</a>
        </td>
        <td>
            <a href="singer?action=delete&id=${st.id}">Delete</a>
        </td>
    </tr>
</c:forEach>

</body>
</html>
