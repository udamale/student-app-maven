<%@ page import="java.util.List" %>
<%@ page import="com.example.studentapp.model.Student" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>List Students</title></head>
<body>
    <h2>All Students</h2>
    <table border="1">
        <tr><th>Roll</th><th>Name</th><th>Class</th></tr>
        <%
            List<Student> students = (List<Student>)request.getAttribute("students");
            if (students != null) {
                for (Student s : students) {
        %>
            <tr>
                <td><%= s.getRoll() %></td>
                <td><%= s.getName() %></td>
                <td><%= s.getStudentClass() %></td>
            </tr>
        <%
                }
            }
        %>
    </table>
    <br/>
    <a href="student">Add another student</a>
</body>
</html>

