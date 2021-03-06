package course.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course.dao.CourseDao;
import course.domain.Course;


/**
 * Servlet implementation class UserServlet
 */

public class CourseServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServletRead() {
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
		Course course = null;
		CourseDao courseDao = new CourseDao();
		
		
		try {
			course = courseDao.findByCourse_number(Integer.parseInt(request.getParameter("course_number")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		
		if(course.getCourse_number()!=null){
					System.out.println(course);
					request.setAttribute("course", course);
					request.getRequestDispatcher("/jsps/course/course_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "course not found");
			request.getRequestDispatcher("/jsps/course/course_read_output.jsp").forward(request, response);
		}
	}
}



