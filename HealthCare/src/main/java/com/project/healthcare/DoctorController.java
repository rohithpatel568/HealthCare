package com.project.healthcare;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/DoctorController")
public class DoctorController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private HealthCareDAO dao;

    public DoctorController() throws IOException {
        dao = new HealthCareDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("doctors", dao.retrieveDoctors());
        RequestDispatcher rd = request.getRequestDispatcher("viewDoctors.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("add".equals(action)) {
            Doctor doctor = new Doctor();
            doctor.setdId(Integer.parseInt(request.getParameter("dId")));
            doctor.setdName(request.getParameter("dName"));
            doctor.setExp(Integer.parseInt(request.getParameter("exp")));
            doctor.setSpecialization(request.getParameter("spec"));
            doctor.setDob(Date.valueOf(request.getParameter("dob"))); 
            doctor.setLocation(request.getParameter("loc"));

            dao.addDoctor(doctor);
            response.sendRedirect("admin.jsp?msg=Doctor+Added");

        } else if ("update".equals(action)) {
            Doctor doctor = new Doctor();
            doctor.setdId(Integer.parseInt(request.getParameter("dId")));
            doctor.setdName(request.getParameter("dName"));
            doctor.setExp(Integer.parseInt(request.getParameter("exp")));
            doctor.setSpecialization(request.getParameter("spec"));
            doctor.setDob(Date.valueOf(request.getParameter("dob")));
            doctor.setLocation(request.getParameter("loc"));

            dao.updateDoctor(doctor);
            response.sendRedirect("admin.jsp?msg=Doctor+Updated");

        } else if ("delete".equals(action)) {
            int dId = Integer.parseInt(request.getParameter("dId"));
            dao.deleteDoctor(dId);
            response.sendRedirect("admin.jsp?msg=Doctor+Deleted");
        }
    }
}
