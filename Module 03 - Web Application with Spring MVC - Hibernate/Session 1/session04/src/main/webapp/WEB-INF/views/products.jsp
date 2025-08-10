<%--
  Created by IntelliJ IDEA.
  User: minhh
  Date: 8/11/2025
  Time: 1:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Danh sách sản phẩm</title>
  <style>
    table {
      width: 60%;
      border-collapse: collapse;
    }
    th, td {
      border: 1px solid black;
      padding: 8px;
      text-align: left;
    }
    th {
      background-color: #f2f2f2;
    }
    form {
      margin-bottom: 20px;
    }
  </style>
</head>
<body>
<h1>Danh sách sản phẩm</h1>

<!-- Thanh tìm kiếm -->
<form action="/products" method="get">
  <label for="searchProductName">Tìm kiếm sản phẩm:</label>
  <input type="text" value="${not empty searchProductName ? searchProductName : ""}" id="searchProductName" name="searchProductName" placeholder="Nhập tên sản phẩm">
  <input type="submit" value="Tìm kiếm">
</form>

<table>
  <thead>
  <tr>
    <th>ID</th>
    <th>Tên sản phẩm</th>
    <th>Giá</th>
    <th>Số lượng</th>
    <th>Mô tả</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="product" items="${products}">
    <tr>
      <td>${product.id}</td>
      <td>${product.productName}</td>
      <td>${product.price}</td>
      <td>${product.stock}</td>
      <td>${product.description}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>