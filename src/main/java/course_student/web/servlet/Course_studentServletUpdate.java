package course_student.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ta_list.dao.Ta_listDao;
import ta_list.domain.Ta_list;

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
		Ta_listDao ta_listdao = new Ta_listDao();
		Ta_list ta_list = null;

		if(method.equals("search"))
		{
			try {
				ta_list = ta_listdao.findByTa_email(request.getParameter("ta_email"));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(ta_list.getTa_email()!=null){
				request.setAttribute("ta_list", ta_list);
				request.getRequestDispatcher("/jsps/ta_list/ta_list_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Student not found");
				request.getRequestDispatcher("/jsps/ta_list/ta_list_update_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Ta_list form = new Ta_list();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}

			form.setTa_course_number(Integer.parseInt(info.get(2)));
			form.setTa_course_department(info.get(3));
			form.setTa_email(request.getParameter("ta_email"));
			try {
				ta_listdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Ta_list Updated");
			request.getRequestDispatcher("/jsps/ta_list/ta_list_read_output.jsp").forward(request, response);
		}
	}
}



