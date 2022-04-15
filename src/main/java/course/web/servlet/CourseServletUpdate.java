package course.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.dao.CourseDao;
import course.domain.Course;

/**
 * Servlet implementation class UserServlet
 */

public class CourseServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseServletUpdate() {
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
		CourseDao coursedao = new CourseDao();
		Course course = null;

		if(method.equals("search"))
		{
			try {
				course = coursedao.findByCourse_number(Integer.parseInt(request.getParameter("course_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(course.getCourse_number()!=null){
				request.setAttribute("course", course);
				request.getRequestDispatcher("/jsps/course/course_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Course not found");
				request.getRequestDispatcher("/jsps/course/course_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Course form = new Course();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}

			form.setTeaching_assistant((info.get(2)));
			form.setProfessor(info.get(3));
			form.setCourse_number(Integer.parseInt(request.getParameter("course_number")));
			try {
				coursedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Course Updated");
			request.getRequestDispatcher("/jsps/course/course_read_output.jsp").forward(request, response);
		}
	}
}



