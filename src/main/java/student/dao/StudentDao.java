package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import queue.domain.Queue;

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
		    preparestatement.setInt(4,form.getQueueID());
		    preparestatement.setString(5,form.getIs_ta());
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
	public void update(Student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "UPDATE student SET full_name = ?, note = ?, queueID = ?, is_ta = ? where student_email = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getFull_name());
			preparestatement.setString(2,form.getNote());
		    preparestatement.setInt(3,form.getQueueID());
		    preparestatement.setString(4, form.getIs_ta());
		    preparestatement.setString(5, form.getStudent_email());
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
	public void delete(String student_email) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "delete from student where student_email = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,student_email);
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findOldStudents() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			String sql = "select * from student"; //FIX SQL?
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Student queue = new Student();
	    		queue.setStudent_email(resultSet.getString("student_email"));
	    		queue.setFull_name(resultSet.getString("full_name"));
	    		queue.setNote(resultSet.getString("note"));
	    		queue.setIs_ta(resultSet.getString("is_ta"));
	    		
//	    		System.out.println(resultSet.getString("queueID"));
	    		String temp = resultSet.getString("queueID");
	    		if(resultSet.getString("queueID") == "" ) {
		    		System.out.println(temp);

	    			queue.setQueueID(0);
	    		}
	    		else {
		    		System.out.println(temp);
	    				
		    		queue.setQueueID(Integer.parseInt(temp));
	    		}
	    		list.add(queue);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findStudentView() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			String sql = "select * from upper_name_view"; //FIX SQL?
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Student queue = new Student();
	    		queue.setFull_name(resultSet.getString("UPPER(full_name)"));
	    		list.add(queue);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
}
