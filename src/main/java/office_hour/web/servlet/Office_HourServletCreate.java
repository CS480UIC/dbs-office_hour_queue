package office_hour.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import office_hour.domain.Office_Hour;
import office_hour.service.Office_HourException;
import office_hour.service.Office_HourService;


/**
 * Servlet implementation class UserServlet
 */

public class Office_HourServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Office_HourServletCreate() {
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
		Office_HourService entity1service = new Office_HourService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Office_Hour form = new Office_Hour();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		form.setId_office_hour(Integer.parseInt(info.get(0)));
		form.setCourse_number(Integer.parseInt(info.get(1)));
		form.setTa_email(info.get(2));
		form.setLocation(info.get(3));
		form.setMeetup_time(info.get(4));
		form.setMeetup_date(java.sql.Date.valueOf(info.get(5)));	
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | Office_HourException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
