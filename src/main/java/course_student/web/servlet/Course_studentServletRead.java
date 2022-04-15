package course_student.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ta_list.dao.Ta_listDao;
import ta_list.domain.Ta_list;


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
		Ta_list ta_list = null;
		Ta_listDao ta_listDao = new Ta_listDao();
		
		try {
			ta_list = ta_listDao.findByTa_email(request.getParameter("ta_email"));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(ta_list.getTa_email()!=null){
					System.out.println(ta_list);
					request.setAttribute("ta_list", ta_list);
					request.getRequestDispatcher("/jsps/ta_list/ta_list_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "ta_list not found");
			request.getRequestDispatcher("/jsps/ta_list/ta_list_read_output.jsp").forward(request, response);
		}
	}
}



