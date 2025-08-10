<%--
  Created by IntelliJ IDEA.
  User: minhh
  Date: 8/11/2025
  Time: 2:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm Sinh Viên</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f4f4f4;
      margin: 0;
      padding: 20px;
    }

    h2 {
      color: #333;
    }

    form {
      background: white;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      margin: auto;
    }

    label {
      display: block;
      margin: 10px 0 5px;
      color: #555;
    }

    input[type="text"],
    input[type="email"],
    input[type="date"],
    input[type="number"] {
      width: 100%;
      padding: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      margin-bottom: 15px;
    }

    button {
      background-color: #5cb85c;
      color: white;
      border: none;
      border-radius: 5px;
      padding: 10px 15px;
      cursor: pointer;
      font-size: 16px;
    }

    button:hover {
      background-color: #4cae4c;
    }

    a {
      display: block;
      text-align: center;
      margin-top: 20px;
      text-decoration: none;
      color: #007bff;
    }

    a:hover {
      text-decoration: underline;
    }
  </style>
</head>
<body>
<h2 style="text-align: center">Thêm Sinh Viên</h2>

<form action="/students/add" method="POST">
  <input type="hidden" name="id">
  <label for="studentName">Tên:</label>
  <input type="text" id="studentName" name="studentName" required/>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" required/>

  <label for="birthday">Ngày Sinh:</label>
  <input type="date" id="birthday" name="birthday" required/>

  <label for="avgMark">Điểm Trung Bình:</label>
  <input type="number" id="avgMark" step="0.01" name="avgMark" required/>

  <button type="submit">Thêm</button>
</form>

<a href="/students">Quay lại danh sách</a>
</body>
</html>
