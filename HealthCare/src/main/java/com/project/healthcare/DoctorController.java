package com.project.healthcare;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

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

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			if ("retrieve".equals(action)) {
				// Normal retrieve (all doctors)
				request.setAttribute("doctors", dao.retrieveDoctors());
				RequestDispatcher rd = request.getRequestDispatcher("viewDoctors.jsp");
				rd.forward(request, response);

			} else if ("specBased".equals(action)) {
				// Retrieve top 3 doctors per specialization
				String[] specs = request.getParameterValues("spec");
				if (specs != null) {
					List<String> specializations = Arrays.asList(specs);
					request.setAttribute("doctors", dao.retrieveBasedOnSpec(specializations));
				}
				RequestDispatcher rd = request.getRequestDispatcher("viewDoctors.jsp");
				rd.forward(request, response);

			} else if ("locBased".equals(action)) {
				// Retrieve top 2 doctors per location
				String[] locs = request.getParameterValues("loc");
				if (locs != null) {
					List<String> locations = Arrays.asList(locs);
					request.setAttribute("doctors", dao.retrieveBasedOnLoc(locations));
				}
				RequestDispatcher rd = request.getRequestDispatcher("viewDoctors.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error.jsp?msg=" + e.getMessage());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");

		try {
			if ("loginAdmin".equals(action) || "loginDoctor".equals(action)) {
				// Login logic
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				String role = action.equals("loginAdmin") ? "admin" : "doctor";

				if (dao.validate(username, password, role)) {
					HttpSession session = request.getSession();
					session.setAttribute("user", username);
					session.setAttribute("role", role);

					if ("admin".equals(role)) {
						response.sendRedirect("admin.jsp");
					} else {
						response.sendRedirect("profile.jsp");
					}
				} else {
					response.sendRedirect("Error.jsp?msg=Invalid+Credentials");
				}

			} else if ("add".equals(action)) {
				Doctor doctor = new Doctor();
				doctor.setdId(Integer.parseInt(request.getParameter("dId")));
				doctor.setdName(request.getParameter("dName"));
				doctor.setExp(Integer.parseInt(request.getParameter("exp")));
				doctor.setSpec(request.getParameter("spec"));
				doctor.setDob(Date.valueOf(request.getParameter("dob"))); // yyyy-MM-dd
				doctor.setLoc(request.getParameter("loc"));

				dao.addDoctor(doctor);
				response.sendRedirect("admin.jsp?msg=Doctor+Added");
			} else if ("update".equals(action)) {
				Doctor doctor = new Doctor();
				doctor.setdId(Integer.parseInt(request.getParameter("dId")));
				doctor.setdName(request.getParameter("dName"));
				doctor.setExp(Integer.parseInt(request.getParameter("exp")));
				doctor.setSpec(request.getParameter("spec"));
				doctor.setDob(Date.valueOf(request.getParameter("dob")));
				doctor.setLoc(request.getParameter("loc"));

				dao.updateDoctor(doctor);
				response.sendRedirect("admin.jsp?msg=Doctor+Updated");

			} else if ("delete".equals(action)) {
				int dId = Integer.parseInt(request.getParameter("dId"));
				dao.deleteDoctor(dId);
				response.sendRedirect("admin.jsp?msg=Doctor+Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("Error.jsp?msg=" + e.getMessage());
		}
	}
}