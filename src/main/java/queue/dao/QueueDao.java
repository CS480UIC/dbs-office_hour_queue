package queue.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import queue.domain.Queue;

/**
 * DDL functions performed in database
 */
public class QueueDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "office_hour_queue"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "@EzPass#"; //TODO change password

	public Queue findById_OH(Integer id_queue) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Queue queue = new Queue();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
		    String sql = "select * from queue where id_queue=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1, id_queue);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("id_queue"));
		    	if(id == id_queue){
		    		queue.setId_queue(id);
		    		queue.setStudent_email(resultSet.getString("student_email"));
		    		queue.setFull_name(resultSet.getString("full_name"));
		    		queue.setFollow_up(resultSet.getString("follow_up"));
		    		queue.setQueue_date(java.sql.Date.valueOf(resultSet.getString("queue_date")));
		    		queue.setOfficeHourID(Integer.parseInt(resultSet.getString("officeHourID")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return queue;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Queue form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "insert into queue values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getId_queue());
		    preparestatement.setString(2, form.getStudent_email());
		    preparestatement.setString(3, form.getFull_name());
		    preparestatement.setString(4, form.getFollow_up());
		    preparestatement.setDate(5, form.getQueue_date());
		    preparestatement.setInt(6, form.getOfficeHourID());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param form
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void update(Queue form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "UPDATE queue SET student_email = ?, full_name = ?, follow_up = ?, queue_date = ?, officeHourID = ? where id_queue = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setString(1, form.getStudent_email());
		    preparestatement.setString(2, form.getFull_name());
		    preparestatement.setString(3, form.getFollow_up());
		    preparestatement.setDate(4, form.getQueue_date());
		    preparestatement.setInt(5, form.getOfficeHourID());
		    preparestatement.setInt(6, form.getId_queue());
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**
	 * @param username
	 * @throws ClassNotFoundException
	 * @throws InstantiationException
	 * @throws IllegalAccessException
	 */
	public void delete(Integer id_queue) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "delete from queue where id_queue = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id_queue);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
