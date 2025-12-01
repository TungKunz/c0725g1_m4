<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 11/27/2025
  Time: 1:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

</head>
<body>
  <div class="container">
    <div class="row" >
        <div class="header col-12">
          <h2 style="justify-items: center">
            Change Money USD -> VND
          </h2>
        </div>
    </div>
    <div class="row">
      <form action="/change" method="get">
        <input value="${money}" name="money" id="money" placeholder="Nhập USD" type="number" class="form-control">
        <button class="btn btn-primary mt-2">Change</button>
      </form>
      <p class="mt-3"><strong>Kết quả: ${result}</strong></p>
    </div>
  </div>
</body>
</html>
