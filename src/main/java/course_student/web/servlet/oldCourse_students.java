package course_student.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import course_student.service.Course_studentService;

/**
 * Servlet implementation class findAll
 */

public class oldCourse_students extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Course_studentService ta_listservice = new Course_studentService();
		try {
			request.setAttribute("Ta_listList", ta_listservice.findOldCourse_students()); //TODO
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
		}
//		try {
//			List<Object> li = ta_listservice.findall(); //TODO
//			for(int i = 0; i < li.size();i++){
//				System.out.println(li.get(i).toString());
//			}
//			
//		} catch (InstantiationException | IllegalAccessException
//				| ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		request.getRequestDispatcher("/jsps/ta_list/q2_old_ta_list.jsp").forward(request, response);
	}

}
