<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh Sách Order</title>
  <style>
    /* CSS Variables */
    :root {
      --primary-color: #28a745; /* Xanh lá: Màu nút bấm chính */
      --accent-color: #008080;  /* Màu Teal/Mint: Màu tiêu đề bảng */
      --light-bg: #f7f7f7;     /* Màu nền nhẹ */
      --shadow-color: rgba(0, 0, 0, 0.15);
    }

    body {
      font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: var(--light-bg);
      color: #333;
    }

    /* Container */
    .container {
      max-width: 900px; /* Tăng kích thước bảng */
      margin: 40px auto;
      padding: 30px;
      background-color: #fff;
      border-radius: 12px;
      box-shadow: 0 10px 20px var(--shadow-color);
    }

    /* Tiêu đề */
    h2 {
      text-align: center;
      color: var(--accent-color);
      margin-bottom: 25px;
      font-weight: 600;
    }

    /* Nút Thêm Order */
    .btn-add {
      display: inline-block;
      padding: 10px 20px;
      background-color: var(--primary-color); /* Màu xanh lá */
      color: white;
      text-decoration: none;
      border-radius: 6px;
      font-weight: 500;
      transition: background-color 0.3s, transform 0.2s;
      margin-bottom: 20px;
    }
    .btn-add:hover {
      background-color: #1e7e34; /* Màu đậm hơn khi hover */
      transform: translateY(-1px);
    }

    /* Table Style */
    table {
      width: 100%;
      border-collapse: separate; /* Thay đổi để dùng border-radius */
      border-spacing: 0;
      margin-top: 20px;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
      overflow: hidden; /* Cần thiết để bo góc hoạt động */
    }

    /* Table Header */
    th {
      background-color: var(--accent-color); /* Màu Teal/Mint */
      color: white;
      padding: 12px 15px;
      text-align: left;
      font-weight: bold;
      text-transform: uppercase;
      letter-spacing: 0.5px;
    }

    /* Table Data Cells */
    td {
      border-top: 1px solid #eee; /* Chỉ kẻ dòng ngang */
      padding: 12px 15px;
      text-align: left;
    }

    /* Table Body Rows */
    tbody tr:nth-child(even) {
      background-color: #fcfcfc; /* Xen kẽ màu nhạt */
    }

    /* Hover effect on rows */
    tbody tr:hover {
      background-color: #e6f7f7; /* Màu Mint nhạt khi hover */
      cursor: pointer;
    }

    /* Message khi không có Order */
    p {
      margin-top: 20px;
      padding: 15px;
      background-color: #fff3cd;
      color: #856404;
      border: 1px solid #ffeeba;
      border-radius: 6px;
      text-align: center;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Danh Sách Order</h2>
  <a href="add" class="btn-add">Thêm Order Mới</a>

  <c:choose>
    <c:when test="${empty orders}">
      <p>Không có Order nào được tìm thấy.</p>
    </c:when>
    <c:otherwise>
      <table>
        <thead>
        <tr>
          <th>ID</th>
          <th>Nước Sốt (Sauces)</th>
          <th>Gia Vị (Seasoning)</th>
          <th>Rau Củ (Veggies)</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${orders}">
          <tr>
            <td><c:out value="${order.id}"/></td>
            <td><c:out value="${order.sauces}"/></td>
            <td><c:out value="${order.seasoning}"/></td>
            <td><c:out value="${order.veggies}"/></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </c:otherwise>
  </c:choose>
</div>
</body>
</html>