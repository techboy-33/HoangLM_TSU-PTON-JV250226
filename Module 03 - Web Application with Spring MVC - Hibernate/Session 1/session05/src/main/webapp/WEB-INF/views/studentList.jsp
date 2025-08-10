<%--
  Created by IntelliJ IDEA.
  User: minhh
  Date: 8/11/2025
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Danh Sách Sinh Viên</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }

    h2 {
      color: #333;
      text-align: center;
    }

    form {
      background: white;
      padding: 15px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      max-width: 500px;
      margin: 20px auto;
    }

    input[type="text"] {
      width: calc(70% - 20px);
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-right: 10px;
    }

    select {
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-right: 10px;
    }

    button {
      background-color: #5cb85c;
      color: white;
      border: none;
      border-radius: 5px;
      padding: 10px 15px;
      cursor: pointer;
    }

    button:hover {
      background-color: #4cae4c;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
      background: white;
    }

    th, td {
      padding: 10px;
      text-align: left;
      border-bottom: 1px solid #ccc;
    }

    th {
      background-color: #f8f8f8;
    }

    a {
      text-decoration: none;
      color: #007bff;
      margin-right: 10px;
    }

    a:hover {
      text-decoration: underline;
    }

    .add-button {
      display: block;
      text-align: center;
      margin-top: 20px;
      background-color: #007bff;
      color: white;
      padding: 10px;
      border-radius: 5px;
      width: 150px;
      margin-left: auto;
      margin-right: auto;
    }

    .add-button:hover {
      background-color: #0056b3;
    }
    #formSearch {
      display: flex;
      justify-content: center;
      gap : 20px ;
    }
  </style>
</head>
<body>

<script c:if="${not empty message}">
  alert('${message}');
</script>

<h2>Danh Sách Sinh Viên</h2>

<form method="GET" action="/students" id="formSearch">
  <input type="text" name="search" value="${search}" placeholder="Tìm kiếm..."/>
  <select name="sort">
    <option value="ASC" selected="${sort == 'ASC'}">Tăng dần</option>
    <option value="DESC" selected="${sort == 'DESC'}">Giảm dần</option>
  </select>
  <button type="submit">Lọc</button>
</form>

<table>
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Ngày Sinh</th>
    <th>Điểm Trung Bình</th>
    <th>Hành Động</th>
  </tr>
  <c:forEach var="student" items="${students}">
    <tr>
      <td>${student.id}</td>
      <td>${student.studentName}</td>
      <td>${student.email}</td>
      <td>${student.birthday}</td>
      <td>${student.avgMark}</td>
      <td>
        <a href="/students/edit/${student.id}">Sửa</a>
        <a href="/students/delete/${student.id}"
           onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này?')">Xóa</a>
      </td>
    </tr>
  </c:forEach>
</table>

<a class="add-button" href="/students/add">Thêm Sinh Viên</a>
</body>
</html>
