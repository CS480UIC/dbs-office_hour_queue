package queue.web.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import queue.dao.QueueDao;
import queue.domain.Queue;


/**
 * Servlet implementation class UserServlet
 */

public class QueueServletRead extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueueServletRead() {
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
		Queue queue = null;
		QueueDao queueDao = new QueueDao();
		
		try {
			queue = queueDao.findById_OH(Integer.parseInt(request.getParameter("id_queue")));
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			e1.printStackTrace();
		}
		
		if(queue.getId_queue()!=null){
					System.out.println(queue);
					request.setAttribute("queue", queue);
					request.getRequestDispatcher("/jsps/queue/queue_read_output.jsp").forward(request, response);
			}
			else{
			request.setAttribute("msg", "Queue not found");
			request.getRequestDispatcher("/jsps/queue/queue_read_output.jsp").forward(request, response);
		}
	}
}



