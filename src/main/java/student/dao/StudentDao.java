package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




//import java.util.ArrayList;
//import java.util.List;

import student.domain.Student;

/**
 * DDL functions performed in database
 */
public class StudentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "office_hour_queue"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "@EzPass#"; //TODO change password

	public Student findByStudent_email(String student_email) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Student student = new Student();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
		    String sql = "select * from student where student_email = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,student_email);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String student_email_ = resultSet.getString("student_email");
		    	if(student_email_.equals(student_email)){
		    		student.setStudent_email(student_email_);
		    		student.setFull_name(resultSet.getString("full_name"));
		    		student.setIs_ta(resultSet.getString("is_ta"));
		    		student.setNote(resultSet.getString("note"));
		    		student.setQueueID(Integer.parseInt(resultSet.getString("queueID")));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return student;
	}	
	
	/**
	 * insert Entity1
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "insert into student values(?,?,?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getStudent_email());
		    preparestatement.setString(2,form.getFull_name());
		    preparestatement.setString(3,form.getNote());
		    preparestatement.setString(4,form.getIs_ta());
		    preparestatement.setInt(5,form.getQueueID());
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
//	public void update(Student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
//			
//			String sql = "UPDATE entity1 SET password = ?, email = ? where username = ?;";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,form.getPassword());
//			preparestatement.setString(2,form.getEmail());
//		    preparestatement.setString(3,form.getUsername());
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	
//	/**
//	 * @param username
//	 * @throws ClassNotFoundException
//	 * @throws InstantiationException
//	 * @throws IllegalAccessException
//	 */
//	public void delete(String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
//			
//			String sql = "delete from entity1 where username = ?";
//			PreparedStatement preparestatement = connect.prepareStatement(sql); 
//		    preparestatement.setString(1,username);
//		    preparestatement.executeUpdate();
//		    connect.close();
//		} catch(SQLException e) {
//			throw new RuntimeException(e);
//		}
//	}
}
