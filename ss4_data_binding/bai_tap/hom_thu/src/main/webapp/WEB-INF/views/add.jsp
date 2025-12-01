<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 01/12/2025
  Time: 1:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form:form action="about" method="get" modelAttribute="homThu">
  Languages :<form:select path="languages" items="${languages}"/>
  size :<form:select path="size" items="${size}"/>
  filler:<form:checkbox path="filler" />
  signature: <form:textarea path="signature"/>
  <form:button type="submit" value="Save">save</form:button>
</form:form>
</body>
</html>