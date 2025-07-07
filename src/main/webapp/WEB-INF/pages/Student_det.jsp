<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student Form</title>
    <link rel="stylesheet" href="<c:url value='/css/form_style.css'/>">
</head>
<body>


<div class="form-container">
    <h2>Add Student</h2>
    <form action="/students/save" method="post">
        <div class="form-group">
            <label>Name:</label>
            <input type="text" name="name" required />
        </div>
        <div class="form-group">
            <label>Grade:</label>
            <input type="text" name="grade" required />
        </div>
        <button type="submit" class="btn-save">Save</button>
    </form>
</div>

</body>
</html>
