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
<h1>FORM CREATE SINGER</h1>
<c:if test='${requestScope["message"]!=null}'>
    <span style="color: blue">${requestScope["message"]}</span>
</c:if>
<form  method="post">
    <label>NAME</label><br>
    <input type="text" name="name"><br>
    <label>AGE</label><br>
    <input type="text" name="age"><br>
    <label>SEX</label><br>
    <input type="text" name="sex"><br>
    <button>Create</button>
</form>

</body>
</html>
