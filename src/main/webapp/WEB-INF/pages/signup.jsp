
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
    <link rel="stylesheet" href="<c:url value='/css/signup_style.css'/>">
</head>
<body>
<div style="position: absolute; top: 20px; width: 100%; text-align: center;">
    <h1 style="font-size: 32px; color: #333; font-weight: bold;">Student Management System</h1>
</div>

    <div class="auth-container">
        <h2>Sign Up</h2>
        <c:if test="${not empty error}">
    <p style="color: red; font-weight: bold;">${error}</p>
</c:if>
        
        <form action="/signup" method="post">
            <label>Username:</label>
            <input type="text" name="username" required><br/>
            <label>Password:</label>
            <input type="password" name="password" required><br/>
            <button type="submit">Sign Up</button>
        </form>
       
        
        <p>Already have an account? <a href="/login">Login</a></p>
    </div>
</body>
</html>

