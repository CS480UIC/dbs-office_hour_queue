package student.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import student.dao.StudentDao;
import student.domain.Student;


/**
 * Servlet implementation class UserServlet
 */

public class StudentServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServletRead() {
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
		Student entity1 = null;
		StudentDao entity1Dao = new StudentDao();
		
		try {
			entity1 = entity1Dao.findByStudent_email(request.getParameter("student_email"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(entity1.getStudent_email()!=null){
					System.out.println(entity1);
					request.setAttribute("student", entity1);
					request.getRequestDispatcher("/jsps/student/student_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Student not found");
			request.getRequestDispatcher("/jsps/student/student_read_output.jsp").forward(request, response);
		}
	}
}



