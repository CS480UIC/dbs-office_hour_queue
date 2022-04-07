package office_hour.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import office_hour.domain.Office_Hour;

/**
 * DDL functions performed in database
 */
public class Office_HourDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "office_hour_queue"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "@EzPass#"; //TODO change password

	public Office_Hour findById_OH(Integer id_office_hour) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Office_Hour office_hour = new Office_Hour();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
		    String sql = "select * from office_hour where id_office_hour=?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id_office_hour);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer id = Integer.parseInt(resultSet.getString("id_office_hour"));
		    	if(id == id_office_hour){
		    		office_hour.setId_office_hour(id);
		    		office_hour.setCourse_number(Integer.parseInt(resultSet.getString("course_number")));
		    		office_hour.setTa_email(resultSet.getString("ta_email"));
		    		office_hour.setLocation(resultSet.getString("location"));
		    		office_hour.setMeetup_time(resultSet.getString("meetup_time"));
		    		office_hour.setMeetup_date(java.sql.Date.valueOf(resultSet.getString("meetup_date")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return office_hour;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Office_Hour form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "insert into office_hour values(?,?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getId_office_hour());
		    preparestatement.setInt(2, form.getCourse_number());
		    preparestatement.setString(3, form.getTa_email());
		    preparestatement.setString(4, form.getLocation());
		    preparestatement.setString(5, form.getMeetup_time());
		    preparestatement.setDate(6, form.getMeetup_date());
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
	public void update(Office_Hour form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "UPDATE office_hour SET course_number = ?, ta_email = ?, location = ?, meetup_time = ?, meetup_date = ? where id_office_hour = ?;";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			
		    preparestatement.setInt(1, form.getCourse_number());
		    preparestatement.setString(2, form.getTa_email());
		    preparestatement.setString(3, form.getLocation());
		    preparestatement.setString(4, form.getMeetup_time());
		    preparestatement.setDate(5, form.getMeetup_date());
		    preparestatement.setInt(6, form.getId_office_hour());
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
	public void delete(Integer id_office_hour) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "delete from office_hour where id_office_hour = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,id_office_hour);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
