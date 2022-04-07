package queue.web.servlet;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import queue.domain.Queue;
import queue.service.QueueException;
import queue.service.QueueService;


/**
 * Servlet implementation class UserServlet
 */

public class QueueServletCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueueServletCreate() {
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
		QueueService entity1service = new QueueService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Queue form = new Queue();
		List<String> info = new ArrayList<String>();

		for(String name : paramMap.keySet()) {
			String[] values = paramMap.get(name);
			info.add(values[0]);
		}
		
		form.setId_queue(Integer.parseInt(info.get(0)));
		form.setStudent_email(info.get(1));
		form.setFull_name(info.get(2));
		form.setFollow_up(info.get(3));
		form.setQueue_date(java.sql.Date.valueOf(info.get(4)));
		form.setOfficeHourID(Integer.parseInt(info.get(5)));
		
		
		try {
			entity1service.create(form);
			response.sendRedirect( request.getContextPath() + "/jsps/main.jsp");
			
		} catch (ClassNotFoundException | QueueException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
		
	}

}
