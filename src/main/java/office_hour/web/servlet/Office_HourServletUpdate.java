package office_hour.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import office_hour.dao.Office_HourDao;
import office_hour.domain.Office_Hour;

/**
 * Servlet implementation class UserServlet
 */

public class Office_HourServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Office_HourServletUpdate() {
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
		Office_HourDao office_hourdao = new Office_HourDao();
		Office_Hour office_hour = null;

		if(method.equals("search"))
		{
			try {
				office_hour = office_hourdao.findById_OH(Integer.parseInt(request.getParameter("id_office_hour")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(office_hour.getId_office_hour()!=null){
				request.setAttribute("office_hour", office_hour);
				request.getRequestDispatcher("/jsps/office_hour/office_hour_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Office Hour not found");
				request.getRequestDispatcher("/jsps/office_hour/office_hour_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Office_Hour form = new Office_Hour();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			
			form.setCourse_number(Integer.parseInt(info.get(2)));
			form.setTa_email(info.get(3));
			form.setLocation(info.get(4));
			form.setMeetup_time(info.get(5));
			form.setMeetup_date(java.sql.Date.valueOf(info.get(6)));	
			form.setId_office_hour(Integer.parseInt(request.getParameter("id_office_hour")));
	

			try {
				office_hourdao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Office Hour Updated");
			request.getRequestDispatcher("/jsps/office_hour/office_hour_read_output.jsp").forward(request, response);
		}
	}
}



