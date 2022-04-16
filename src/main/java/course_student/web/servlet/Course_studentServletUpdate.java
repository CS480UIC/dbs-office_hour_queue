package course_student.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course_student.dao.Course_studentDao;
import course_student.domain.Course_student;

/**
 * Servlet implementation class UserServlet
 */

public class Course_studentServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Course_studentServletUpdate() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		Course_studentDao course_studentdao = new Course_studentDao();
		Course_student course_student = null;

		if(method.equals("search"))
		{
			try {
				course_student = course_studentdao.findBySM_CN(request.getParameter("student_email"), Integer.parseInt(request.getParameter("course_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(course_student.getStudent_email()!=null && course_student.getCourse_number()!=null){
				request.setAttribute("course_student", course_student);
				request.getRequestDispatcher("/jsps/course_student/course_student_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Course_student not found");
				request.getRequestDispatcher("/jsps/course_student/course_student_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Course_student form = new Course_student();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}

			form.setStudent_email(request.getParameter("student_email"));
			form.setCourse_number(Integer.parseInt(request.getParameter("course_number")));
			form.setStudent_email_UPDATE(info.get(3));
			form.setCourse_number_UPDATE(Integer.parseInt(info.get(4)));
			
			try {
				course_studentdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Course_student Updated");
			request.getRequestDispatcher("/jsps/course_student/course_student_read_output.jsp").forward(request, response);
		}
	}
}



