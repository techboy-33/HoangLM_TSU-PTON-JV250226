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
  <title>Sửa Sinh Viên</title>
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
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      max-width: 400px;
      margin: 20px auto;
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
      width: 100%;
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
<h2>Sửa Sinh Viên</h2>

<form action="/students/edit/${student.id}" method="POST">
  <label for="studentName">Tên:</label>
  <input type="text" id="studentName" name="studentName" value="${student.studentName}" required/>

  <label for="email">Email:</label>
  <input type="email" id="email" name="email" value="${student.email}" required/>

  <label for="birthday">Ngày Sinh:</label>
  <input type="date" id="birthday" name="birthday" value="${student.birthday}" required/>

  <label for="avgMark">Điểm Trung Bình:</label>
  <input type="number" id="avgMark" step="0.01" name="avgMark" value="${student.avgMark}" required/>

  <button type="submit">Cập Nhật</button>
</form>

<a href="/students">Quay lại danh sách</a>
</body>
</html>
