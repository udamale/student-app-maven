<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Add Student</title></head>
<body>
    <h2>Add Student</h2>
    <form method="post" action="student">
        Roll: <input type="text" name="roll" /><br/>
        Name: <input type="text" name="name" /><br/>
        Class: <input type="text" name="studentClass" /><br/>
        <input type="submit" value="Add" />
    </form>
    <br/>
    <a href="student?action=list">View All Students</a>
</body>
</html>

