package office_hour.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import office_hour.dao.Office_HourDao;
import office_hour.domain.Office_Hour;


/**
 * Servlet implementation class UserServlet
 */

public class Office_HourServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Office_HourServletDelete() {
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
		Office_HourDao office_hourDao = new Office_HourDao();
		Office_Hour office_hour = null;
		if(method.equals("search"))
		{
			try {
				office_hour = office_hourDao.findById_OH(Integer.parseInt(request.getParameter("id_office_hour")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
		
			if(office_hour.getId_office_hour()!=null){
						System.out.println(office_hour);
						request.setAttribute("office_hour", office_hour);
						request.getRequestDispatcher("/jsps/office_hour/office_hour_delete_output.jsp").forward(request, response);			
				}
				else{
				request.setAttribute("msg", "Office Hour not found");
				request.getRequestDispatcher("/jsps/office_hour/office_hour_read_output.jsp").forward(request, response);
			}
		}
		else if(method.equals("delete"))
		{	
			try {
				office_hourDao.delete(Integer.parseInt(request.getParameter("id_office_hour")));
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (InstantiationException e1) {
				e1.printStackTrace();
			} catch (IllegalAccessException e1) {
				e1.printStackTrace();
			}
			request.setAttribute("msg", "Office Hour Deleted");
			request.getRequestDispatcher("/jsps/office_hour/office_hour_read_output.jsp").forward(request, response);
		}
	}
}



