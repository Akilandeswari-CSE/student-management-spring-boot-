<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link rel="stylesheet" href="<c:url value='/css/form_style.css'/>">
</head>
<body>
<div class="form-container">
    <h2>Edit Student</h2>
    <form action="/students/update" method="post">
        <input type="hidden" name="id" value="${student.id}" />
        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" value="${student.name}" required />
        </div>
        <div class="form-group">
            <label>Grade:</label>
            <input type="text" name="grade" value="${student.grade}" required />
        </div>
        <button type="submit" class="btn-save">Update</button>
    </form>
</div>
</body>
</html>
