<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 3/10/2022
  Time: 1:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="#">Back Menu</a>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: blue">${requestScope["message"]}</span>
</c:if>
<form method="post">
    <label >NAME</label><br>
    <input type="text" name="name" value="${requestScope["singer"].getName()}" ><br>
    <label >AGE</label><br>
    <input type="text" name="age" value="${requestScope["singer"].getAge()}" ><br>
    <label >SEX</label><br>
    <input type="text" name="sex" value="${requestScope["singer"].getSex()}" ><br>
    <button>Edit</button>
</form>
</body>
</html>
