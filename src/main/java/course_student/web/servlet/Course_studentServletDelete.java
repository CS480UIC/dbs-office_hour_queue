package course_student.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course_student.dao.Course_studentDao;
import course_student.domain.Course_student;


/**
 * Servlet implementation class UserServlet
 */

public class Course_studentServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course_studentServletDelete() {
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
		Course_studentDao course_studentDao = new Course_studentDao();
		Course_student course_student = null;
		if(method.equals("search"))
		{
			try {
				System.out.println(Integer.parseInt(request.getParameter("course_number")));

				course_student = course_studentDao.findBySM_CN(request.getParameter("student_email"), Integer.parseInt(request.getParameter("course_number")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(course_student.getStudent_email()!=null && course_student.getCourse_number()!=null){
						System.out.println(course_student);
						request.setAttribute("course_student", course_student);
						request.getRequestDispatcher("/jsps/course_student/course_student_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Course_student not found");
				request.getRequestDispatcher("/jsps/course_student/course_student_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	

			try {
				System.out.println(request.getParameter("student_email"));
				System.out.println(Integer.parseInt(request.getParameter("course_number")));

				course_studentDao.delete(request.getParameter("student_email"),  Integer.parseInt(request.getParameter("course_number")) );
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "course_student Deleted");
			request.getRequestDispatcher("/jsps/course_student/course_student_read_output.jsp").forward(request, response);
		}
	}
}



