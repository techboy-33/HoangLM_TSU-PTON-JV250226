<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: minhh
  Date: 8/13/2025
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Food</title>
</head>
<body>
    <h3>Food List</h3>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Food Id</th>
                <th>Food Name</th>
                <th>Food Ingredients</th>
                <th>Food Instructions</th>
                <th>Food PrepTime</th>
                <th>Food CookTime</th>
                <th>Food Image</th>
<%--                <th>Food Status</th>--%>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${listFood}" var="food" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${food.foodId}</td>
                    <td>${food.foodName}</td>
                    <td>${food.ingredients}</td>
                    <td>${food.instructions}</td>
                    <td>${food.prepTime}</td>
                    <td>${food.cookTime}</td>
                    <td>${food.imagePath}</td>
                    <td>${food.status?"Active":"Inactive"}</td>
                    <td>
                        <a href="<%=request.getContextPath()%>/foodController/initUpdate?foodId=${food.foodId}">Update</a>
                        <a href="<%=request.getContextPath()%>/foodController/delete?foodId=${food.foodId}">Delete</a>
                    </td>
                </tr>
            </c:forEach>

        </tbody>
    </table>
<a href="<%=request.getContextPath()%>/foodController/initCreate">Create new food</a>
</body>
</html>
