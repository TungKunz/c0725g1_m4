<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring Calculator</title>
</head>
<body>
<h1>Máy Tính Đơn Giản (Simple Calculator)</h1>

<h3 style="color: blue;">Kết Quả: **${ketqua}**</h3>
<hr>

<form action="calculator" method="get">

    <input name="num1" placeholder="Số thứ nhất (num1)" type="number" required value="${num1}">
    <input name="num2" placeholder="Số thứ hai (num2)" type="number" required value="${num2}">

    <br><br>

    <button type="submit" name="action" value="+">Cộng (+)</button>

    <button type="submit" name="action" value="-">Trừ (-)</button>

    <button type="submit" name="action" value="*">Nhân (*)</button>

    <button type="submit" name="action" value="/">Chia (/)</button>

</form>

</body>
</html>