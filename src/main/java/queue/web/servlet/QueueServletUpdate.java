package queue.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import queue.dao.QueueDao;
import queue.domain.Queue;

/**
 * Servlet implementation class UserServlet
 */

public class QueueServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueueServletUpdate() {
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
		QueueDao queuedao = new QueueDao();
		Queue queue = null;

		if(method.equals("search"))
		{
			try {
				queue = queuedao.findById_OH(Integer.parseInt(request.getParameter("id_queue")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}

			if(queue.getId_queue()!=null){
				request.setAttribute("queue", queue);
				request.getRequestDispatcher("/jsps/queue/queue_update_output.jsp").forward(request, response);

			}
			else{
				request.setAttribute("msg", "Queue not found");
				request.getRequestDispatcher("/jsps/queue/queue_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("update"))
		{
			Map<String,String[]> paramMap = request.getParameterMap();
			Queue form = new Queue();
			List<String> info = new ArrayList<String>();

			for(String name : paramMap.keySet()) {
				String[] values = paramMap.get(name);
				info.add(values[0]);
			}
			
			
			form.setStudent_email(info.get(2));
			form.setFull_name(info.get(3));
			form.setFollow_up(info.get(4));
			form.setQueue_date(java.sql.Date.valueOf(info.get(5)));
			form.setOfficeHourID(Integer.parseInt(request.getParameter("officeHourID")));
			form.setId_queue(Integer.parseInt(request.getParameter("id_queue")));
	

			try {
				queuedao.update(form);

			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Queue Updated");
			request.getRequestDispatcher("/jsps/queue/queue_read_output.jsp").forward(request, response);
		}
	}
}



