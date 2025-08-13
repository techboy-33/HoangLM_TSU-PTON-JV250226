<%--
  Created by IntelliJ IDEA.
  User: minhh
  Date: 8/13/2025
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Food</title>
</head>
<body>
    <form action="<%=request.getContextPath()%>/foodController/create" method="post">
        <label for="foodName">Food Name</label>
        <input type="text" id="foodName" name="foodName"/><br>
        <label for="ingredients">Ingredients</label>
        <input type="text" id="ingredients" name="ingredients"/><br>
        <label for="instructions">Instructions</label>
        <input type="text" id="instructions" name="instructions"/><br>
        <label for="prepTime">Prep Time</label>
        <input type="text" id="prepTime" name="prepTime"/><br>
        <label for="cookTime">Cook Time</label>
        <input type="text" id="cookTime" name="cookTime"/><br>
        <label for="imagePath">Image</label>
        <input type="text" id="imagePath" name="imagePath"/><br>
        <label for="active">Status</label>
        <input type="radio" id="active" name="status" value="true" checked/><label for="active">Active</label>
        <input type="radio" id="inActive" name="status" value="false" checked/><label for="inActive">Inactive</label><br>
        <input type="submit" value="Create"/>
    </form>
</body>
</html>
