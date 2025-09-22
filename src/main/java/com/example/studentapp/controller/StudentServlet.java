package com.example.studentapp.controller;

import com.example.studentapp.dao.StudentDao;
import com.example.studentapp.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {

    private StudentDao dao = new StudentDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // determine action
        String action = req.getParameter("action");
        if ("list".equals(action)) {
            List<Student> students = dao.getAllStudents();
            req.setAttribute("students", students);
            req.getRequestDispatcher("/views/listStudents.jsp").forward(req, resp);
        } else {
            // default: show add form
            req.getRequestDispatcher("/views/addStudent.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // read form
        String rollStr = req.getParameter("roll");
        String name = req.getParameter("name");
        String studentClass = req.getParameter("studentClass");
        int roll = 0;
        try {
            roll = Integer.parseInt(rollStr);
        } catch (NumberFormatException e) {
            // handle error or set default
        }
        Student s = new Student(roll, name, studentClass);
        dao.addStudent(s);
        resp.sendRedirect(req.getContextPath() + "/student?action=list");
    }
}

