package course_student.domain;

/**
 * Student object
 * 
 * @author Darian Danciu and Amanuel Odicho
 * 
 */
public class Course_student {
	
	private String student_email;
	private Integer course_number;
	/**
	 * @return the student_email
	 */
	public String getStudent_email() {
		return student_email;
	}
	/**
	 * @param student_email the student_email to set
	 */
	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}
	/**
	 * @return the course_number
	 */
	public Integer getCourse_number() {
		return course_number;
	}
	/**
	 * @param course_number the course_number to set
	 */
	public void setCourse_number(Integer course_number) {
		this.course_number = course_number;
	}


}
