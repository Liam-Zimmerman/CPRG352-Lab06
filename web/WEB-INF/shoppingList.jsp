<%-- 
    Document   : shoppingList
    Created on : Oct 16, 2021, 9:22:40 PM
    Author     : 854292
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username}.</p> <a href="ShoppingList?logout" action="logout">Logout</a>
        <h2>List</h2>
        <form method="POST" action="?add">
        <label>Add item:</label> 
        <input type="text" name="item">
        <button name="add" action="add">Add</button>
        </form>
        <c:forEach items="${items}" var="items">
            <input type="radio" action="delete">
            <label>${items}</label>
            <br>
        </c:forEach>
    </body>
</html>
