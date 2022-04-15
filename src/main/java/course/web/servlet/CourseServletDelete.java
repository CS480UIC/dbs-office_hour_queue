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

public class CourseServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServletDelete() {
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
		CourseDao courseDao = new CourseDao();
		Course course = null;
		if(method.equals("search"))
		{
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
						request.getRequestDispatcher("/jsps/course/course_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Course not found");
				request.getRequestDispatcher("/jsps/course/course_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				courseDao.delete(request.getParameter("course_number"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Course Deleted");
			request.getRequestDispatcher("/jsps/course/course_read_output.jsp").forward(request, response);
		}
	}
}



