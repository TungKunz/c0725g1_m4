<%-- BẠN PHẢI THÊM DÒNG NÀY VÀO ĐẦU FILE JSP --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Dictionary</title>
</head>
<body>
<h2>English → Vietnamese Dictionary</h2>

<form method="post" action="/translate">
  <input type="text" name="word" placeholder="Enter English word">
  <button type="submit">Translate</button>
</form>

<c:if test="${searched == true && empty result}">
  <p><strong>Không tìm thấy từ: ${word}.</strong></p>
</c:if>

<c:if test="${not empty result}">
  <p>Kết quả: <strong>${result}</strong></p>
</c:if>

</body>
</html>