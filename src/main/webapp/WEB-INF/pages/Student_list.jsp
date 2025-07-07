<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Student List</title>
   <link rel="stylesheet" href="<c:url value='/css/list_style.css?v=2'/>">

</head>
<body>
     
     
    <h2>All Students</h2>
    <div class="logstyle">
      <a href="/home" class="home-btn">Home</a>
        <a href="/logout" class="logout-btn">Logout</a>
      
    </div>

    <table border="1" cellpadding="10">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Grade</th>
            <th>Action</th>
        </tr>
        <c:forEach var="student" items="${students}">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.grade}</td>
                 <td>
                <a href="/students/edit/${student.id}" class="update-btn">Update</a> |
                <a href="/students/delete/${student.id}" class="del-btn" >Delete</a>
            </td>
            </tr>
            
        </c:forEach>
    </table>
    <br/>
<div style="text-align: center;">
    <a href="/form">
        <button style="padding: 10px 20px; background-color: #007bff; color: white; border: none; border-radius: 5px; cursor: pointer;">
            Back to Form
        </button>
    </a>
</div>
    
</body>
</html>
