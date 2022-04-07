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

public class QueueServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QueueServletDelete() {
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
		QueueDao queueDao = new QueueDao();
		Queue queue = null;
		if(method.equals("search"))
		{
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
						request.getRequestDispatcher("/jsps/queue/queue_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Queue not found");
				request.getRequestDispatcher("/jsps/queue/queue_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				queueDao.delete(Integer.parseInt(request.getParameter("id_queue")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Queue Deleted");
			request.getRequestDispatcher("/jsps/queue/queue_read_output.jsp").forward(request, response);
		}
	}
}



