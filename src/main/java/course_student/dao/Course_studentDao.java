package course_student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import course_student.domain.Course_student;

/**
 * DDL functions performed in database
 */
public class Course_studentDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "office_hour_queue"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "@EzPass#"; //TODO change password

	public Course_student findBySM_CN(String student_email_p, Integer course_number_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Course_student course_student = new Course_student();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
		    String sql = "select * from course_student where student_email = ? AND course_number = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,student_email_p);
		    preparestatement.setInt(2,course_number_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	String student_email = resultSet.getString("student_email");
		    	Integer course_number = Integer.parseInt(resultSet.getString("course_number"));
		    	if(student_email.equals(student_email_p) & course_number.equals(course_number_p)){
		    		course_student.setStudent_email(student_email);
		    		course_student.setCourse_number(course_number);
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return course_student;
	}	
	
	/**
	 * insert Ta_list
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Course_student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "insert into course_student values(?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getStudent_email());
		    preparestatement.setInt(2,form.getCourse_number());
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
	public void update(Course_student form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "UPDATE course_student SET student_email = ?, course_number = ? WHERE student_email = ? AND course_number = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,form.getStudent_email());
		    preparestatement.setInt(2,form.getCourse_number());
		    preparestatement.setString(3, form.getStudent_email());
		    preparestatement.setInt(4,form.getCourse_number());
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
	public void delete(String student_email, String course_number) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "delete from course_student where student_email = ? AND course_number = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setString(1,student_email);
		    preparestatement.setInt(2,Integer.parseInt(course_number));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findOldCourse_students() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			String sql = "select * from course_student"; //FIX SQL?
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Course_student course_student = new Course_student();
				course_student.setStudent_email(resultSet.getString("student_email"));
	    		course_student.setCourse_number(Integer.parseInt(resultSet.getString("course_number")));
	    		list.add(course_student);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
}
