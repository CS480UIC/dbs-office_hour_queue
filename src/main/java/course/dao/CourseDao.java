package course.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import course.domain.Course;

/**
 * DDL functions performed in database
 */
public class CourseDao {
	
	/**
	 * user name to connect to the database 
	 */
	private String MySQL_user = "office_hour_queue"; //TODO change user
	
	/**
	 * password of your username to connect to the database
	 */
	private String MySQL_password = "@EzPass#"; //TODO change password

	public Course findByCourse_number(Integer course_number_p) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Course course = new Course();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
		    String sql = "select * from course where course_number = ?";
		    PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,course_number_p);
		    ResultSet resultSet = preparestatement.executeQuery();

		    while(resultSet.next()){
		    	Integer course_number = Integer.parseInt(resultSet.getString("course_number"));
		    	
		    	if(course_number.equals(course_number_p)){
		    		course.setCourse_number(course_number);
		    		course.setTeaching_assistant(resultSet.getString("teaching_assistant"));
		    		course.setProfessor(resultSet.getString("professor"));
		    	}
		    }
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return course;
	}	
	
	/**
	 * insert Ta_list
	 * @param form
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	
	public void add(Course form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "insert into course values(?,?,?)";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCourse_number());
		    preparestatement.setString(2,form.getTeaching_assistant());
		    preparestatement.setString(3,form.getProfessor());
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
	public void update(Course form) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "UPDATE course SET course_number = ?, teaching_assistant = ?, professor = ? WHERE course_number = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,form.getCourse_number());
		    preparestatement.setString(2,form.getTeaching_assistant());
		    preparestatement.setString(3, form.getProfessor());
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
	public void delete(String course_number) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			
			String sql = "delete from course where course_number = ?";
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
		    preparestatement.setInt(1,Integer.parseInt(course_number));
		    preparestatement.executeUpdate();
		    connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Object> findOldCourses() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			String sql = "select * from course"; //FIX SQL?
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Course course = new Course();
				course.setCourse_number(Integer.parseInt(resultSet.getString("course_number")));
	    		course.setTeaching_assistant(resultSet.getString("teaching_assistant"));
	    		course.setProfessor(resultSet.getString("professor"));
	    		list.add(course);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	
	public List<Object> findCoursesView() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			String sql = "select * from course_view"; //FIX SQL?
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Course course = new Course();
				course.setCourse_number(Integer.parseInt(resultSet.getString("course_number")));
	    		course.setTeaching_assistant(resultSet.getString("teaching_assistant"));
	    		course.setProfessor(resultSet.getString("professor"));
	    		list.add(course);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
	public List<Object> findCoursesView2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		List<Object> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/office_hour_queue", MySQL_user, MySQL_password);
			String sql = "select * from inner_join_view"; //FIX SQL?
			PreparedStatement preparestatement = connect.prepareStatement(sql); 
			ResultSet resultSet = preparestatement.executeQuery();			
			while(resultSet.next()){
				Course course = new Course();
				course.setCourse_number(Integer.parseInt(resultSet.getString("course_number")));
	    		list.add(course);
			 }
			connect.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return list;
		
	}
	
}
