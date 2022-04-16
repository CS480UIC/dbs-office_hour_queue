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

public class Course_studentServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course_studentServletRead() {
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
		Course_student course_student = null;
		Course_studentDao course_studentDao = new Course_studentDao();
		
		try {
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
					request.getRequestDispatcher("/jsps/course_student/course_student_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "course_student not found");
			request.getRequestDispatcher("/jsps/course_student/course_student_read_output.jsp").forward(request, response);
		}
	}
}



